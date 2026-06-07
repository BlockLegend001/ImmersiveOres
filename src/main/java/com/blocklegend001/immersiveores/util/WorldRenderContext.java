package com.blocklegend001.immersiveores.util;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import org.joml.Matrix4f;

public class WorldRenderContext {

    private final Camera camera;
    private final Matrix4f matrixStack;

    public WorldRenderContext(Matrix4f positionMatrix) {
        this.matrixStack = new Matrix4f();
        this.matrixStack.mul(positionMatrix);
        this.camera = Minecraft.getInstance().gameRenderer.getMainCamera();
    }

    public Camera camera() {
        return camera;
    }

    public Matrix4f matrixStack() {
        return matrixStack;
    }

    public MultiBufferSource.BufferSource consumers() {
        return Minecraft.getInstance()
                .renderBuffers()
                .bufferSource();
    }
}