package com.darkxrat.mantax.func.bug;

public class DelayInvisible {
    public static final String NAMA = "DELAY INVISIBLE";
    public static final String TIPE = "BUG";

    public static String func() {
        return "\u2060".repeat(50) + "DELAY_INVISIBLE" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "DELAY_INVISIBLE_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "DELAY_INVISIBLE_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}