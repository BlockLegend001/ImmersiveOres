package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
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
    private void afterRenderMain(ObjectAllocator allocator, RenderTickCounter tickCounter, boolean renderBlockOutline,
                                 Camera camera, Matrix4f positionMatrix, Matrix4f matrix4f, Matrix4f projectionMatrix,
                                 GpuBufferSlice fogBuffer, Vector4f fogColor, boolean renderSky, CallbackInfo ci) {

        MinecraftClient client = MinecraftClient.getInstance();
        if (!ImmersiveOresClient.SHOW_OUTLINE_ENABLED) return;
        if (client.world == null || client.player == null) return;

        ItemStack heldItem = client.player.getMainHandStack();
        if (heldItem.isEmpty()) return;

        if (!(client.crosshairTarget instanceof BlockHitResult blockHit)) return;
        if (blockHit.getType() != HitResult.Type.BLOCK) return;

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

        if (isHammer && !client.world.getBlockState(blockHit.getBlockPos()).isIn(BlockTags.PICKAXE_MINEABLE)) return;
        if (isExcavator && !client.world.getBlockState(blockHit.getBlockPos()).isIn(BlockTags.SHOVEL_MINEABLE)) return;

        WorldRenderContext ctx = new WorldRenderContext(positionMatrix);
        renderSelectionBox(ctx, blockHit.getBlockPos(), blockHit.getSide(), range);
    }

    private void renderSelectionBox(WorldRenderContext ctx, BlockPos origin, Direction side, int range) {
        Vec3d cameraPos = ctx.camera().getPos();
        MatrixStack matrices = ctx.matrixStack();
        VertexConsumer buffer = ctx.consumers().getBuffer(RenderLayer.getLines());

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
                .expand(0.002f);

        drawBox(matrices, buffer, box, 1f, 1f, 1f, 1f);
        ctx.consumers().draw();
    }

    private static void drawBox(MatrixStack matrices, VertexConsumer buffer, Box box, float r, float g, float b, float a) {
        Matrix4f matrix = matrices.peek().getPositionMatrix();

        float[][] corners = {
                {(float) box.minX, (float) box.minY, (float) box.minZ},
                {(float) box.maxX, (float) box.minY, (float) box.minZ},
                {(float) box.minX, (float) box.maxY, (float) box.minZ},
                {(float) box.maxX, (float) box.maxY, (float) box.minZ},
                {(float) box.minX, (float) box.minY, (float) box.maxZ},
                {(float) box.maxX, (float) box.minY, (float) box.maxZ},
                {(float) box.minX, (float) box.maxY, (float) box.maxZ},
                {(float) box.maxX, (float) box.maxY, (float) box.maxZ}
        };

        int[][] edges = {
                {0,1},{1,3},{3,2},{2,0},
                {4,5},{5,7},{7,6},{6,4},
                {0,4},{1,5},{2,6},{3,7}
        };

        for (int[] e : edges) {
            float[] p1 = corners[e[0]], p2 = corners[e[1]];
            buffer.vertex(matrix, p1[0], p1[1], p1[2]).color(r, g, b, a).light(0xF000F0).normal(1.0F, 0.0F, 0.0F);
            buffer.vertex(matrix, p2[0], p2[1], p2[2]).color(r, g, b, a).light(0xF000F0).normal(1.0F, 0.0F, 0.0F);
        }
    }
}
