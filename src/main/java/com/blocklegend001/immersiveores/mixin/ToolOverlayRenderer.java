package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.util.WorldRenderContext;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class ToolOverlayRenderer {

    @Inject(method = "render", at = @At("TAIL"))
    private void afterRenderMain(
            ObjectAllocator allocator,
            RenderTickCounter tickCounter,
            boolean renderBlockOutline,
            Camera camera,
            Matrix4f positionMatrix,
            Matrix4f matrix4f,
            Matrix4f projectionMatrix,
            GpuBufferSlice fogBuffer,
            Vector4f fogColor,
            boolean renderSky,
            CallbackInfo ci
    ) {

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null || client.player == null) return;

        ItemStack heldItem = client.player.getMainHandStack();
        if (heldItem.isEmpty()) return;

        if (!(client.crosshairTarget instanceof BlockHitResult hit)) return;
        if (hit.getType() != HitResult.Type.BLOCK) return;

        boolean isHammer = RadiusMap.HAMMERS_RADIUS.containsKey(heldItem.getItem());
        boolean isExcavator = RadiusMap.EXCAVATORS_RADIUS.containsKey(heldItem.getItem());
        if (!isHammer && !isExcavator) return;

        int range;
        if (client.player.isSneaking()) {
            range = 0;
        } else if (isHammer) {
            range = RadiusMap.HAMMERS_RADIUS.getOrDefault(heldItem.getItem(), 0);
        } else {
            range = RadiusMap.EXCAVATORS_RADIUS.getOrDefault(heldItem.getItem(), 0);
        }

        BlockPos origin = hit.getBlockPos();

        if (isHammer && !client.world.getBlockState(origin).isIn(BlockTags.PICKAXE_MINEABLE)) return;
        if (isExcavator && !client.world.getBlockState(origin).isIn(BlockTags.SHOVEL_MINEABLE)) return;

        WorldRenderContext ctx = new WorldRenderContext(positionMatrix);
        renderSelectionBox(ctx, origin, hit.getSide(), range);
    }

    private void renderSelectionBox(WorldRenderContext ctx, BlockPos origin, Direction side, int range) {

        Vec3d cameraPos = ctx.camera().getCameraPos();
        MatrixStack matrices = ctx.matrixStack();

        VertexConsumer buffer =
                ctx.consumers().getBuffer(RenderLayers.LINES);

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, minZ = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, maxZ = Integer.MIN_VALUE;

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {

                BlockPos pos = switch (side.getAxis()) {
                    case Y -> origin.add(x, 0, y);
                    case X -> origin.add(0, y, x);
                    case Z -> origin.add(x, y, 0);
                };

                minX = Math.min(minX, pos.getX());
                minY = Math.min(minY, pos.getY());
                minZ = Math.min(minZ, pos.getZ());

                maxX = Math.max(maxX, pos.getX() + 1);
                maxY = Math.max(maxY, pos.getY() + 1);
                maxZ = Math.max(maxZ, pos.getZ() + 1);
            }
        }

        Box box = new Box(minX, minY, minZ, maxX, maxY, maxZ)
                .offset(-cameraPos.x, -cameraPos.y, -cameraPos.z)
                .expand(0.002);

        drawBox(matrices, buffer, box, 1f, 1f, 1f, 1f);
        ctx.consumers().draw();
    }

    // ===============================
    // DRAW BOX (CUSTOM)
    // ===============================

    private static void drawBox(
            MatrixStack matrices,
            VertexConsumer buffer,
            Box box,
            float r, float g, float b, float a
    ) {
        Matrix4f matrix = matrices.peek().getPositionMatrix();

        float minX = (float) box.minX;
        float minY = (float) box.minY;
        float minZ = (float) box.minZ;
        float maxX = (float) box.maxX;
        float maxY = (float) box.maxY;
        float maxZ = (float) box.maxZ;

        // Bottom
        line(buffer, matrix, minX, minY, minZ, maxX, minY, minZ, r,g,b,a);
        line(buffer, matrix, maxX, minY, minZ, maxX, minY, maxZ, r,g,b,a);
        line(buffer, matrix, maxX, minY, maxZ, minX, minY, maxZ, r,g,b,a);
        line(buffer, matrix, minX, minY, maxZ, minX, minY, minZ, r,g,b,a);

        // Top
        line(buffer, matrix, minX, maxY, minZ, maxX, maxY, minZ, r,g,b,a);
        line(buffer, matrix, maxX, maxY, minZ, maxX, maxY, maxZ, r,g,b,a);
        line(buffer, matrix, maxX, maxY, maxZ, minX, maxY, maxZ, r,g,b,a);
        line(buffer, matrix, minX, maxY, maxZ, minX, maxY, minZ, r,g,b,a);

        // Vertical
        line(buffer, matrix, minX, minY, minZ, minX, maxY, minZ, r,g,b,a);
        line(buffer, matrix, maxX, minY, minZ, maxX, maxY, minZ, r,g,b,a);
        line(buffer, matrix, maxX, minY, maxZ, maxX, maxY, maxZ, r,g,b,a);
        line(buffer, matrix, minX, minY, maxZ, minX, maxY, maxZ, r,g,b,a);
    }

    private static void line(
            VertexConsumer buffer,
            Matrix4f matrix,
            float x1, float y1, float z1,
            float x2, float y2, float z2,
            float r, float g, float b, float a
    ) {
        buffer.vertex(matrix, x1, y1, z1)
                .color(r, g, b, a)
                .lineWidth(2.0f)
                .normal(1.0F, 0.0F, 0.0F);

        buffer.vertex(matrix, x2, y2, z2)
                .color(r, g, b, a)
                .lineWidth(2.0f)
                .normal(1.0F, 0.0F, 0.0F);
    }
}
