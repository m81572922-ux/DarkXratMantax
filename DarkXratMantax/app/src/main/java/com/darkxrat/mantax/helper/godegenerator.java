package com.darkxrat.mantax.helper;

import java.util.Random;

public class CodeGenerator {

    // Generate kode 6 digit
    public static String generateKode() {
        Random random = new Random();
        int kode = 100000 + random.nextInt(900000);
        return String.valueOf(kode);
    }

    // Validasi kode 6 digit
    public static boolean isValidKode(String kode) {
        if (kode == null) return false;
        if (kode.length() != 6) return false;
        try {
            Integer.parseInt(kode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}