package com.darkxrat.mantax;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    ImageView btnBack;
    Button btnLogout;
    LinearLayout menuRole, menuGantiPassword, layoutMenuManzxrat;
    LinearLayout menuGantiIcon, menuGantiMusik, menuGantiVideo, menuGantiFoto, menuHapusRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnBack = findViewById(R.id.btnBack);
        btnLogout = findViewById(R.id.btnLogout);
        menuRole = findViewById(R.id.menuRole);
        menuGantiPassword = findViewById(R.id.menuGantiPassword);
        layoutMenuManzxrat = findViewById(R.id.layoutMenuManzxrat);
        menuGantiIcon = findViewById(R.id.menuGantiIcon);
        menuGantiMusik = findViewById(R.id.menuGantiMusik);
        menuGantiVideo = findViewById(R.id.menuGantiVideo);
        menuGantiFoto = findViewById(R.id.menuGantiFoto);
        menuHapusRole = findViewById(R.id.menuHapusRole);

        SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
        String role = sp.getString("role", "MEMBER");

        if (role.equals("MANZXRAT")) {
            layoutMenuManzxrat.setVisibility(View.VISIBLE);
        }

        btnBack.setOnClickListener(v -> finish());

        menuRole.setOnClickListener(v ->
            startActivity(new Intent(SettingsActivity.this, RoleManagementActivity.class)));

        menuGantiPassword.setOnClickListener(v ->
            Toast.makeText(this, "Fitur Ganti Password", Toast.LENGTH_SHORT).show());

        menuGantiIcon.setOnClickListener(v ->
            Toast.makeText(this, "Ganti Icon", Toast.LENGTH_SHORT).show());

        menuGantiMusik.setOnClickListener(v ->
            Toast.makeText(this, "Ganti Musik", Toast.LENGTH_SHORT).show());

        menuGantiVideo.setOnClickListener(v ->
            Toast.makeText(this, "Ganti Animasi Video", Toast.LENGTH_SHORT).show());

        menuGantiFoto.setOnClickListener(v ->
            Toast.makeText(this, "Ganti Foto Utama", Toast.LENGTH_SHORT).show());

        menuHapusRole.setOnClickListener(v ->
            Toast.makeText(this, "Hapus Role", Toast.LENGTH_SHORT).show());

        btnLogout.setOnClickListener(v -> {
            sp.edit().clear().apply();
            Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}