package com.darkxrat.mantax.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class WaLinkHelper {

    // Buka WA dengan pesan kode
    public static void kirimKodeKeWa(Context context, String nomor, String kode) {
        try {
            String url = "https://wa.me/" + nomor + "?text=" + kode;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Buka WA biasa (chat)
    public static void bukaWa(Context context, String nomor) {
        try {
            String url = "https://wa.me/" + nomor;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Buka Telegram
    public static void bukaTelegram(Context context, String username) {
        try {
            String url = "https://t.me/" + username;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Buka link custom
    public static void bukaLink(Context context, String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}