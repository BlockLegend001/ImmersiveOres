package com.blocklegend001.immersiveores.util;

import com.mojang.blaze3d.platform.InputConstants;

public class ScreenUtils {
    public static boolean isShiftDown() {
        return InputConstants.isKeyDown(InputConstants.KEY_LSHIFT);
    }
}
