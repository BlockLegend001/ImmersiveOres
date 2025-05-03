package com.blocklegend001.immersiveores.util;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;

public class OverlayRender {
    public static void drawBox(Matrix4f matrix, VertexConsumer buffer, AABB box, float r, float g, float b, float a) {
        float minX = (float) box.minX;
        float minY = (float) box.minY;
        float minZ = (float) box.minZ;
        float maxX = (float) box.maxX;
        float maxY = (float) box.maxY;
        float maxZ = (float) box.maxZ;

        float[][] corners = {
                {minX, minY, minZ}, {maxX, minY, minZ}, {minX, maxY, minZ}, {maxX, maxY, minZ},
                {minX, minY, maxZ}, {maxX, minY, maxZ}, {minX, maxY, maxZ}, {maxX, maxY, maxZ}
        };

        int[][] edges = {
                {0,1},{1,3},{3,2},{2,0},
                {4,5},{5,7},{7,6},{6,4},
                {0,4},{1,5},{2,6},{3,7}
        };

        for (int[] edge : edges) {
            float[] p1 = corners[edge[0]];
            float[] p2 = corners[edge[1]];
            buffer.addVertex(matrix, p1[0], p1[1], p1[2]).setColor(r, g, b, a).setNormal(1, 0, 0);
            buffer.addVertex(matrix, p2[0], p2[1], p2[2]).setColor(r, g, b, a).setNormal(1, 0, 0);
        }
    }
}