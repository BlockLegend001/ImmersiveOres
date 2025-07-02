package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import com.blocklegend001.immersiveores.util.tools.OverlayRenderer;
import com.mojang.blaze3d.resource.GraphicsResourceAllocator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererHammerMixin {

    @Inject(method = "renderLevel", at = @At("TAIL"))
    private void renderLevelAfter(GraphicsResourceAllocator p_361796_, DeltaTracker p_348530_, boolean p_109603_, Camera p_109604_, GameRenderer p_109605_, LightTexture p_109606_, Matrix4f p_254120_, Matrix4f p_323920_, CallbackInfo ci) {

        if (Minecraft.getInstance().level == null || Minecraft.getInstance().player == null) {
            return;
        }

        ItemStack heldItem = Minecraft.getInstance().player.getMainHandItem();
        if (!(heldItem.getItem() instanceof Hammer)) {
            return;
        }

        if (!(Minecraft.getInstance().hitResult instanceof BlockHitResult blockHit) || blockHit.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockPos origin = blockHit.getBlockPos();
        Direction side = blockHit.getDirection();
        int range;
        if (Minecraft.getInstance().player.isShiftKeyDown()) {
            range = 0;
        } else {
            range = RadiusMap.getHammerRadius().get(heldItem.getItem());
        }

        if (!Minecraft.getInstance().level.getBlockState(origin).is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return;
        }

        AABB box = getSelectionBox(range, side, origin);

        Vec3 cameraPos = p_109604_.getPosition();
        box = box.move(-cameraPos.x, -cameraPos.y, -cameraPos.z);

        Matrix4f matrix = p_254120_;
        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        VertexConsumer builder = buffer.getBuffer(RenderType.lines());

        OverlayRenderer.drawBox(matrix, builder, box, 1f, 1f, 1f, 1f);

        buffer.endBatch();
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