package com.blocklegend001.immersiveores.util.tools.excavator;

import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
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

public class ExcavatorOverlayRenderer {
    public static void init() {
        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.world == null || client.player == null) return;

            ItemStack heldItem = client.player.getMainHandStack();
            if (!(heldItem.getItem() instanceof Excavator)) return;

            if (!(client.crosshairTarget instanceof BlockHitResult blockHit) || blockHit.getType() != HitResult.Type.BLOCK) return;

            Direction side = blockHit.getSide();
            BlockPos origin = blockHit.getBlockPos();
            int range = client.player.isSneaking() ? 0 : RadiusMap.EXCAVATORS_RADIUS.getOrDefault(heldItem.getItem(), 1);

            if (!client.world.getBlockState(origin).isIn(BlockTags.SHOVEL_MINEABLE)) return;

            VertexConsumerProvider.Immediate buffers = client.getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer buffer = buffers.getBuffer(RenderLayer.getLines());
            MatrixStack matrices = context.matrixStack();

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

            Box box = new Box(minX, minY, minZ, maxX, maxY, maxZ);

            drawBox(matrices, buffer, box, 1f, 1f, 1f, 1f);

            buffers.draw();
        });
    }

    private static void drawBox(MatrixStack matrices, VertexConsumer buffer, Box box, float r, float g, float b, float a) {
        MinecraftClient client = MinecraftClient.getInstance();
        Vec3d cameraPos = client.gameRenderer.getCamera().getPos();

        Matrix4f matrix = matrices.peek().getPositionMatrix();

        float[][] corners = {
                {(float)(box.minX - cameraPos.x), (float)(box.minY - cameraPos.y), (float)(box.minZ - cameraPos.z)},
                {(float)(box.maxX - cameraPos.x), (float)(box.minY - cameraPos.y), (float)(box.minZ - cameraPos.z)},
                {(float)(box.minX - cameraPos.x), (float)(box.maxY - cameraPos.y), (float)(box.minZ - cameraPos.z)},
                {(float)(box.maxX - cameraPos.x), (float)(box.maxY - cameraPos.y), (float)(box.minZ - cameraPos.z)},
                {(float)(box.minX - cameraPos.x), (float)(box.minY - cameraPos.y), (float)(box.maxZ - cameraPos.z)},
                {(float)(box.maxX - cameraPos.x), (float)(box.minY - cameraPos.y), (float)(box.maxZ - cameraPos.z)},
                {(float)(box.minX - cameraPos.x), (float)(box.maxY - cameraPos.y), (float)(box.maxZ - cameraPos.z)},
                {(float)(box.maxX - cameraPos.x), (float)(box.maxY - cameraPos.y), (float)(box.maxZ - cameraPos.z)}
        };

        int[][] edges = {
                {0,1},{1,3},{3,2},{2,0},
                {4,5},{5,7},{7,6},{6,4},
                {0,4},{1,5},{2,6},{3,7}
        };

        for (int[] e : edges) {
            float[] p1 = corners[e[0]];
            float[] p2 = corners[e[1]];

            buffer.vertex(matrix, p1[0], p1[1], p1[2])
                    .color(r, g, b, a)
                    .light(0xF000F0)
                    .normal(0f, 1f, 0f)
                    .next();

            buffer.vertex(matrix, p2[0], p2[1], p2[2])
                    .color(r, g, b, a)
                    .light(0xF000F0)
                    .normal(0f, 1f, 0f)
                    .next();
        }
    }

}