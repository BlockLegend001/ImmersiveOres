package com.blocklegend001.immersiveores.util.color;

import net.minecraft.network.chat.TextColor;
import org.jspecify.annotations.Nullable;

public interface ColoredBlock {
    @Nullable TextColor getColor();
}
