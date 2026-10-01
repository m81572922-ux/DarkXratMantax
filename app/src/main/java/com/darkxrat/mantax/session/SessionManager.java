package com.darkxrat.mantax.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String PREF_NAME = "auth";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_ROLE = "role";
    private static final String KEY_EXPIRED = "expired";
    private static final String KEY_LOGIN = "isLogin";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    // Simpan session login
    public void createLoginSession(String username, String role, String expired) {
        editor.putBoolean(KEY_LOGIN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_ROLE, role);
        editor.putString(KEY_EXPIRED, expired);
        editor.apply();
    }

    // Cek login
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_LOGIN, false);
    }

    // Ambil username
    public String getUsername() {
        return pref.getString(KEY_USERNAME, "");
    }

    // Ambil role
    public String getRole() {
        return pref.getString(KEY_ROLE, "MEMBER");
    }

    // Ambil expired
    public String getExpired() {
        return pref.getString(KEY_EXPIRED, "7 DAY");
    }

    // Cek apakah MANZXRAT
    public boolean isManzxrat() {
        return getRole().equals("MANZXRAT");
    }

    // Logout
    public void logout() {
        editor.clear();
        editor.apply();
    }
}