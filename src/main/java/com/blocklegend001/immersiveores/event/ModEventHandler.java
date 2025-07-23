package com.blocklegend001.immersiveores.event;

public class ModEventHandler {
    private static boolean preventFallDamage = false;

    public static void onBootsRemoved() {
        preventFallDamage = true;
    }

    public static boolean shouldPreventFallDamage() {
        return preventFallDamage;
    }

    public static void resetFallDamagePrevention() {
        preventFallDamage = false;
    }
}
