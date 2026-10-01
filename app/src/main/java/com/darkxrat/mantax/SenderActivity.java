package com.darkxrat.mantax;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class SenderActivity extends AppCompatActivity {

    ImageView btnBack;
    EditText etNomorSender;
    Button btnKirimKode, btnSalinKode, btnDaftarPrivate;
    LinearLayout layoutKode, layoutPrivateUser;
    TextView tvKode, tvPrivateStatus, tvGlobalStatus, tvPrivateUserStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        btnBack = findViewById(R.id.btnBack);
        etNomorSender = findViewById(R.id.etNomorSender);
        btnKirimKode = findViewById(R.id.btnKirimKode);
        btnSalinKode = findViewById(R.id.btnSalinKode);
        btnDaftarPrivate = findViewById(R.id.btnDaftarPrivate);
        layoutKode = findViewById(R.id.layoutKode);
        layoutPrivateUser = findViewById(R.id.layoutPrivateUser);
        tvKode = findViewById(R.id.tvKode);
        tvPrivateStatus = findViewById(R.id.tvPrivateStatus);
        tvGlobalStatus = findViewById(R.id.tvGlobalStatus);
        tvPrivateUserStatus = findViewById(R.id.tvPrivateUserStatus);

        // Cek role
        SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
        String role = sp.getString("role", "MEMBER");

        // Kalo MANZXRAT, tampilkan Private User
        if (role.equals("MANZXRAT")) {
            layoutPrivateUser.setVisibility(View.VISIBLE);
        }

        // Tombol back
        btnBack.setOnClickListener(v -> finish());

        // Tombol daftar private
        btnDaftarPrivate.setOnClickListener(v -> {
            etNomorSender.requestFocus();
            Toast.makeText(this, "Masukin nomor sender dulu", Toast.LENGTH_SHORT).show();
        });

        // Tombol kirim kode
        btnKirimKode.setOnClickListener(v -> {
            String nomor = etNomorSender.getText().toString().trim();
            if (nomor.isEmpty()) {
                Toast.makeText(this, "Isi nomor dulu!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Generate kode 6 digit
            String kode = generateKode();
            tvKode.setText(kode);
            layoutKode.setVisibility(View.VISIBLE);

            // Kirim notifikasi WA (nanti di-implement)
            Toast.makeText(this, "Kode dikirim ke WA: " + nomor, Toast.LENGTH_LONG).show();
        });

        // Tombol salin kode
        btnSalinKode.setOnClickListener(v -> {
            String kode = tvKode.getText().toString();
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("kode", kode);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Kode disalin: " + kode, Toast.LENGTH_SHORT).show();
        });
    }

    private String generateKode() {
        Random random = new Random();
        int kode = 100000 + random.nextInt(900000);
        return String.valueOf(kode);
    }
}