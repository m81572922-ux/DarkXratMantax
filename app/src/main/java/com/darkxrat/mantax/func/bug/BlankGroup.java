package com.darkxrat.mantax.func.bug;

public class BlankGroup {
    public static final String NAMA = "BLANK GROUP";
    public static final String TIPE = "BUG";

    public static String func() {
        return "\u2060".repeat(50) + "BLANK_GROUP" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "BLANK_GROUP_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "BLANK_GROUP_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}