package com.darkxrat.mantax;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvUsername, tvRole, tvExpired, navBug, navTools, navSadap, navChat, navProfil;
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
        navBug = findViewById(R.id.navBug);
        navTools = findViewById(R.id.navTools);
        navSadap = findViewById(R.id.navSadap);
        navChat = findViewById(R.id.navChat);
        navProfil = findViewById(R.id.navProfil);

        SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
        String user = sp.getString("username", "User");
        String role = sp.getString("role", "MEMBER");

        tvUsername.setText(user);
        tvRole.setText(role);

        if (role.equals("MANZXRAT")) {
            tvExpired.setText("PERMANEN");
            tvExpired.setTextColor(getResources().getColor(R.color.warning));
        } else {
            tvExpired.setText("7 DAY");
            tvExpired.setTextColor(getResources().getColor(R.color.text_gray));
        }

        // Tombol Quick Action
        btnBug.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, BugActivity.class)));

        btnSender.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, SenderActivity.class)));

        // Bottom Nav
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