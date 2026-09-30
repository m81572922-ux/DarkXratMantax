package com.darkxrat.mantax.func.sadap;

public class Story {
    public static final String NAMA = "STORY";
    public static final String TIPE = "SADAP";

    public static String func() {
        return "\u2060".repeat(50) + "STORY" + "\u2060".repeat(50);
    }

    public static String funcHard() {
        return "\u2060".repeat(100) + "STORY_HARD" + "\u2060".repeat(100);
    }

    public static String funcUltra() {
        return "\u2060".repeat(200) + "STORY_ULTRA" + "\u2060".repeat(200);
    }

    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}