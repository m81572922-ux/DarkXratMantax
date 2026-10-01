package com.darkxrat.mantax;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    ImageView btnBack;
    Button btnSettings;
    TextView tvProfileUsername, tvProfileRole, tvProfileExpired;
    TextView tvInfoUsername, tvInfoRole, tvInfoExpired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBack = findViewById(R.id.btnBack);
        btnSettings = findViewById(R.id.btnSettings);
        tvProfileUsername = findViewById(R.id.tvProfileUsername);
        tvProfileRole = findViewById(R.id.tvProfileRole);
        tvProfileExpired = findViewById(R.id.tvProfileExpired);
        tvInfoUsername = findViewById(R.id.tvInfoUsername);
        tvInfoRole = findViewById(R.id.tvInfoRole);
        tvInfoExpired = findViewById(R.id.tvInfoExpired);

        SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
        String user = sp.getString("username", "User");
        String role = sp.getString("role", "MEMBER");
        String expired = sp.getString("expired", "7 DAY");

        tvProfileUsername.setText(user);
        tvProfileRole.setText(role);
        tvProfileExpired.setText(expired);
        tvInfoUsername.setText(user);
        tvInfoRole.setText(role);
        tvInfoExpired.setText(expired);

        btnBack.setOnClickListener(v -> finish());

        btnSettings.setOnClickListener(v ->
            startActivity(new Intent(ProfileActivity.this, SettingsActivity.class)));
    }
}