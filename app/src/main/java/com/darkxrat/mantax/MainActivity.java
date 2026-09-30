package com.darkxrat.mantax;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvUsername, tvRole, tvExpired;
    LinearLayout btnBug, btnSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tvUsername);
        tvRole = findViewById(R.id.tvRole);
        tvExpired = findViewById(R.id.tvExpired);
        btnBug = findViewById(R.id.btnBug);
        btnSender = findViewById(R.id.btnSender);

        SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
        String user = sp.getString("username", "User");
        String role = sp.getString("role", "MEMBER");

        tvUsername.setText(user);
        tvRole.setText(role);

        // Expired khusus MANZXRAT
        if (role.equals("MANZXRAT")) {
            tvExpired.setText("PERMANEN");
            tvExpired.setTextColor(getResources().getColor(R.color.warning));
        } else {
            tvExpired.setText("7 DAY");
            tvExpired.setTextColor(getResources().getColor(R.color.text_gray));
        }

        // Tombol Bug
        btnBug.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, BugActivity.class));
        });

        // Tombol Sender
        btnSender.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SenderActivity.class));
        });
    }
}