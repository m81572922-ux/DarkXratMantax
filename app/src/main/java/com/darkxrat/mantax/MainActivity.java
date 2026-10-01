package com.darkxrat.mantax;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView btnMenu;
    TextView tvUsername, tvRole, tvExpired, tvOnline;
    LinearLayout btnBug, btnSender;
    TextView navHome, navBug, navTools, navSadap, navChat, navProfil;
    TextView tvTanggal, tvBulan, tvHari;
    TextView tvSubuh, tvDzuhur, tvAshar, tvMaghrib, tvIsya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INIT
        btnMenu = findViewById(R.id.btnMenu);
        tvUsername = findViewById(R.id.tvUsername);
        tvRole = findViewById(R.id.tvRole);
        tvExpired = findViewById(R.id.tvExpired);
        tvOnline = findViewById(R.id.tvOnline);
        btnBug = findViewById(R.id.btnBug);
        btnSender = findViewById(R.id.btnSender);
        navHome = findViewById(R.id.navHome);
        navBug = findViewById(R.id.navBug);
        navTools = findViewById(R.id.navTools);
        navSadap = findViewById(R.id.navSadap);
        navChat = findViewById(R.id.navChat);
        navProfil = findViewById(R.id.navProfil);
        tvTanggal = findViewById(R.id.tvTanggal);
        tvBulan = findViewById(R.id.tvBulan);
        tvHari = findViewById(R.id.tvHari);
        tvSubuh = findViewById(R.id.tvSubuh);
        tvDzuhur = findViewById(R.id.tvDzuhur);
        tvAshar = findViewById(R.id.tvAshar);
        tvMaghrib = findViewById(R.id.tvMaghrib);
        tvIsya = findViewById(R.id.tvIsya);

        // AMBIL DATA USER
        SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
        String user = sp.getString("username", "User");
        String role = sp.getString("role", "MEMBER");
        String expired = sp.getString("expired", "7 DAY");

        tvUsername.setText(user);
        tvRole.setText(role);
        tvExpired.setText(expired);

        if (role.equals("MANZXRAT")) {
            tvExpired.setTextColor(getResources().getColor(R.color.warning));
        }

        // KALENDER
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfTanggal = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat sdfBulan = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
        SimpleDateFormat sdfHari = new SimpleDateFormat("EEEE", Locale.getDefault());

        tvTanggal.setText(sdfTanggal.format(cal.getTime()));
        tvBulan.setText(sdfBulan.format(cal.getTime()));
        tvHari.setText(sdfHari.format(cal.getTime()));

        // JADWAL ADZAN (STATIS)
        tvSubuh.setText("Subuh   04:30");
        tvDzuhur.setText("Dzuhur  12:00");
        tvAshar.setText("Ashar   15:15");
        tvMaghrib.setText("Maghrib 18:00");
        tvIsya.setText("Isya    19:15");

        // MENU 3 GARIS → SETTINGS
        btnMenu.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, SettingsActivity.class)));

        // QUICK ACTIONS
        btnBug.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, BugActivity.class)));

        btnSender.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, SenderActivity.class)));

        // BOTTOM NAV
        navHome.setOnClickListener(v -> {
            // udah di home
        });

        navBug.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, BugActivity.class)));

        navTools.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, ToolsActivity.class)));

        navSadap.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, SadapActivity.class)));

        navChat.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, SenderActivity.class)));

        navProfil.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
    }
}