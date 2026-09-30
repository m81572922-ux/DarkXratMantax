package com.darkxrat.mantax.func.sadap;

public class BugGroup {
    public static final String NAMA = "BUG GROUP";
    public static final String TIPE = "SADAP";

    public static String func() {
        return "\u2060".repeat(50) + "BUG_GROUP" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "BUG_GROUP_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "BUG_GROUP_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}