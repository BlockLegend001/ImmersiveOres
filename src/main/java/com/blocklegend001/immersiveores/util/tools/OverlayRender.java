package com.blocklegend001.immersiveores.util.tools;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;

public class OverlayRender {
    public static void drawBox(
            Matrix4f matrices,
            VertexConsumer buffer,
            AABB box,
            float r, float g, float b, float a
    ) {
        Matrix4f matrix = matrices.normal();

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
        buffer.addVertex(matrix, x1, y1, z1)
                .setColor(r, g, b, a)
                .setLineWidth(2.0f)
                .setNormal(1.0F, 0.0F, 0.0F);

        buffer.addVertex(matrix, x2, y2, z2)
                .setColor(r, g, b, a)
                .setLineWidth(2.0f)
                .setNormal(1.0F, 0.0F, 0.0F);
    }
}