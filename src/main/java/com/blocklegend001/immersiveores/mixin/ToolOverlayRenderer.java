package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.util.WorldRenderContext;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.resource.GraphicsResourceAllocator;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.chunk.ChunkSectionsToRender;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class ToolOverlayRenderer {

    @Inject(
            method = "renderLevel",
            at = @At("TAIL")
    )
    private void onRenderLevel(
            GraphicsResourceAllocator resourceAllocator,
            DeltaTracker deltaTracker,
            boolean renderOutline,
            CameraRenderState cameraState,
            Matrix4fc modelViewMatrix,
            GpuBufferSlice terrainFog,
            Vector4f fogColor,
            boolean shouldRenderSky,
            ChunkSectionsToRender chunkSectionsToRender,
            CallbackInfo ci
    ) {
        Minecraft client = Minecraft.getInstance();
        if (!ImmersiveOresClient.SHOW_OUTLINE_ENABLED) return;
        if (client.level == null || client.player == null) return;

        ItemStack heldItem = client.player.getMainHandItem();
        if (heldItem.isEmpty()) return;

        if (!(client.hitResult instanceof BlockHitResult hit)) return;
        if (hit.getType() != HitResult.Type.BLOCK) return;

        boolean isHammer = RadiusMap.HAMMERS_RADIUS.containsKey(heldItem.getItem());
        boolean isExcavator = RadiusMap.EXCAVATORS_RADIUS.containsKey(heldItem.getItem());
        if (!isHammer && !isExcavator) return;

        int range;
        if (client.player.isShiftKeyDown()) {
            range = 0;
        } else if (isHammer) {
            range = RadiusMap.HAMMERS_RADIUS.getOrDefault(heldItem.getItem(), 0);
        } else {
            range = RadiusMap.EXCAVATORS_RADIUS.getOrDefault(heldItem.getItem(), 0);
        }

        BlockPos origin = hit.getBlockPos();

        if (isHammer   && !client.level.getBlockState(origin).is(BlockTags.MINEABLE_WITH_PICKAXE)) return;
        if (isExcavator && !client.level.getBlockState(origin).is(BlockTags.MINEABLE_WITH_SHOVEL))  return;

        WorldRenderContext ctx = new WorldRenderContext((Matrix4f) modelViewMatrix);

        MultiBufferSource.BufferSource bufferSource = ctx.consumers();
        VertexConsumer buffer = bufferSource.getBuffer(RenderTypes.lines());

        renderSelectionBox(ctx.matrixStack(), buffer, ctx.camera().position(), origin, hit.getDirection(), range);

        bufferSource.endLastBatch();
    }

    private void renderSelectionBox(
            Matrix4f matrix,
            VertexConsumer buffer,
            Vec3 camPos,
            BlockPos origin,
            Direction side,
            int range
    ) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, minZ = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, maxZ = Integer.MIN_VALUE;

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                BlockPos pos = switch (side.getAxis()) {
                    case Y -> origin.offset(x, 0, y);
                    case X -> origin.offset(0, y, x);
                    case Z -> origin.offset(x, y, 0);
                };
                minX = Math.min(minX, pos.getX());
                minY = Math.min(minY, pos.getY());
                minZ = Math.min(minZ, pos.getZ());
                maxX = Math.max(maxX, pos.getX() + 1);
                maxY = Math.max(maxY, pos.getY() + 1);
                maxZ = Math.max(maxZ, pos.getZ() + 1);
            }
        }

        AABB box = new AABB(minX, minY, minZ, maxX, maxY, maxZ)
                .move(-camPos.x, -camPos.y, -camPos.z)
                .inflate(0.002);

        drawBox(buffer, matrix, box, 1f, 1f, 1f, 1f);
    }

    private static void drawBox(VertexConsumer buffer, Matrix4f matrix, AABB box,
                                float r, float g, float b, float a) {
        float x0 = (float) box.minX, y0 = (float) box.minY, z0 = (float) box.minZ;
        float x1 = (float) box.maxX, y1 = (float) box.maxY, z1 = (float) box.maxZ;

        line(buffer, matrix, x0, y0, z0, x1, y0, z0, r,g,b,a);
        line(buffer, matrix, x1, y0, z0, x1, y0, z1, r,g,b,a);
        line(buffer, matrix, x1, y0, z1, x0, y0, z1, r,g,b,a);
        line(buffer, matrix, x0, y0, z1, x0, y0, z0, r,g,b,a);

        line(buffer, matrix, x0, y1, z0, x1, y1, z0, r,g,b,a);
        line(buffer, matrix, x1, y1, z0, x1, y1, z1, r,g,b,a);
        line(buffer, matrix, x1, y1, z1, x0, y1, z1, r,g,b,a);
        line(buffer, matrix, x0, y1, z1, x0, y1, z0, r,g,b,a);

        line(buffer, matrix, x0, y0, z0, x0, y1, z0, r,g,b,a);
        line(buffer, matrix, x1, y0, z0, x1, y1, z0, r,g,b,a);
        line(buffer, matrix, x1, y0, z1, x1, y1, z1, r,g,b,a);
        line(buffer, matrix, x0, y0, z1, x0, y1, z1, r,g,b,a);
    }

    private static void line(VertexConsumer buffer, Matrix4f matrix,
                             float x1, float y1, float z1,
                             float x2, float y2, float z2,
                             float r, float g, float b, float a) {
        float dx = x2-x1, dy = y2-y1, dz = z2-z1;
        float len = (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
        if (len == 0) return;
        buffer.addVertex(matrix, x1, y1, z1).setColor(r,g,b,a).setLineWidth(2.0F).setNormal(dx/len, dy/len, dz/len);
        buffer.addVertex(matrix, x2, y2, z2).setColor(r,g,b,a).setLineWidth(2.0F).setNormal(dx/len, dy/len, dz/len);
    }
}