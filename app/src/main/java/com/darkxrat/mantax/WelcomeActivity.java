package com.darkxrat.mantax;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Button btnSignIn, btnDeveloper, btnOwner, btnBeliAkses, btnContactSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnDeveloper = findViewById(R.id.btnDeveloper);
        btnOwner = findViewById(R.id.btnOwner);
        btnBeliAkses = findViewById(R.id.btnBeliAkses);
        btnContactSupport = findViewById(R.id.btnContactSupport);

        // SIGN IN → LOGIN
        btnSignIn.setOnClickListener(v ->
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class)));

        // DEVELOPER → TELEGRAM
        btnDeveloper.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/Rohmanzz"));
            startActivity(i);
        });

        // OWNER → WHATSAPP
        btnOwner.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://wa.me/6285846219230"));
            startActivity(i);
        });

        // BELI AKSES → TELEGRAM
        btnBeliAkses.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/Rohmanzz"));
            startActivity(i);
        });

        // CONTACT SUPPORT → WHATSAPP
        btnContactSupport.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://wa.me/6285846219230"));
            startActivity(i);
        });
    }
}