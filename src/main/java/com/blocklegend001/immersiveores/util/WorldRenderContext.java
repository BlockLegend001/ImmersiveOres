package com.blocklegend001.immersiveores.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;

public class WorldRenderContext {

    private final Camera camera;
    private final MatrixStack matrixStack;

    public WorldRenderContext(Matrix4f positionMatrix) {
        this.matrixStack = new MatrixStack();
        this.matrixStack.multiplyPositionMatrix(positionMatrix);
        this.camera = MinecraftClient.getInstance().gameRenderer.getCamera();
    }

    public Camera camera() {
        return camera;
    }

    public MatrixStack matrixStack() {
        return matrixStack;
    }

    public VertexConsumerProvider.Immediate consumers() {
        return MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
    }
}
