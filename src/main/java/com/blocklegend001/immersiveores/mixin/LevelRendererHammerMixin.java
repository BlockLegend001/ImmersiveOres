package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererHammerMixin {
    @Inject(method = "renderLevel", at = @At("TAIL"))
    private void renderLevelAfter(PoseStack poseStack, float partialTicks, long p_109602_, boolean p_109603_,
                                  Camera camera, GameRenderer p_109605_, LightTexture p_109606_,
                                  Matrix4f projection, CallbackInfo ci) {

        Minecraft mc = Minecraft.getInstance();

        if (mc.level == null || mc.player == null) return;

        ItemStack held = mc.player.getMainHandItem();
        if (!(held.getItem() instanceof Hammer)) return;

        if (!(mc.hitResult instanceof BlockHitResult hit)) return;

        BlockPos origin = hit.getBlockPos();
        if (!mc.level.getBlockState(origin).is(BlockTags.MINEABLE_WITH_PICKAXE)) return;

        int range = mc.player.isShiftKeyDown() ? 0 : RadiusMap.getHammerRadius().get(held.getItem());

        AABB box = getSelectionBox(range, hit.getDirection(), origin);

        Vec3 cam = camera.getPosition();
        AABB shifted = box.move(-cam.x, -cam.y, -cam.z);

        poseStack.pushPose();

        PoseStack.Pose pose = poseStack.last();
        Matrix4f matrix = pose.pose();

        RenderSystem.depthMask(false);
        RenderSystem.disableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.lineWidth(2.0f);

        VertexConsumer lines = mc.renderBuffers().bufferSource().getBuffer(RenderType.LINES);

        LevelRenderer.renderLineBox(
                poseStack,
                lines,
                shifted,
                1f, 1f, 1f, 1f
        );

        mc.renderBuffers().bufferSource().endBatch(RenderType.LINES);

        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);

        poseStack.popPose();
    }

    private static AABB getSelectionBox(int range, Direction side, BlockPos origin) {
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

        return new AABB(minX, minY, minZ, maxX, maxY, maxZ);
    }
}