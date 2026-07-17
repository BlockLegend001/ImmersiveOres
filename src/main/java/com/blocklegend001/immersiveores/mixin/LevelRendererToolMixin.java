package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import com.blocklegend001.immersiveores.util.tools.OverlayRender;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.resource.GraphicsResourceAllocator;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
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
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererToolMixin {

    @Inject(method = "renderLevel", at = @At("TAIL"))
    private void renderLevelAfter(GraphicsResourceAllocator p_367325_, DeltaTracker p_342180_, boolean p_109603_, Camera camera, Matrix4f matrix4f1, Matrix4f p_330527_, Matrix4f p_429784_, GpuBufferSlice p_407881_, Vector4f p_410175_, boolean p_407316_, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        if (!ImmersiveOres.SHOW_OUTLINE_ENABLED) return;
        if (mc.level == null || mc.player == null) return;

        ItemStack heldItem = mc.player.getMainHandItem();
        BlockHitResult blockHit;
        if (!(mc.hitResult instanceof BlockHitResult hit) || hit.getType() != HitResult.Type.BLOCK) return;
        blockHit = hit;

        BlockPos origin = blockHit.getBlockPos();
        Direction side = blockHit.getDirection();

        int range;

        if (mc.player.isShiftKeyDown()) {
            range = 0;
        } else if (heldItem.getItem() instanceof Excavator && RadiusMap.getExcavatorRadius().containsKey(heldItem.getItem())) {
            if (!mc.level.getBlockState(origin).is(BlockTags.MINEABLE_WITH_SHOVEL)) return;
            range = RadiusMap.getExcavatorRadius().get(heldItem.getItem());
        } else if (heldItem.getItem() instanceof Hammer && RadiusMap.getHammerRadius().containsKey(heldItem.getItem())) {
            if (!mc.level.getBlockState(origin).is(BlockTags.MINEABLE_WITH_PICKAXE)) return;
            range = RadiusMap.getHammerRadius().get(heldItem.getItem());
        } else {
            return;
        }

        AABB box = getSelectionBox(range, side, origin);
        Vec3 cameraPos = camera.position();
        box = box.move(-cameraPos.x, -cameraPos.y, -cameraPos.z);

        VertexConsumer builder = mc.renderBuffers().bufferSource().getBuffer(RenderTypes.LINES);
        OverlayRender.drawBox(matrix4f1, builder, box, 1f, 1f, 1f, 1f);
        mc.renderBuffers().bufferSource().endBatch();
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