package com.darkxrat.mantax;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SadapActivity extends AppCompatActivity {

    ImageView btnBack;
    TextView tvServerStatus;
    LinearLayout device1, device2, device3;
    LinearLayout btnKunciLayar, btnLampu, btnSuara, btnMenuApk;
    LinearLayout btnKamera, btnWhatsapp, btnGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadap);

        btnBack = findViewById(R.id.btnBack);
        tvServerStatus = findViewById(R.id.tvServerStatus);
        device1 = findViewById(R.id.device1);
        device2 = findViewById(R.id.device2);
        device3 = findViewById(R.id.device3);
        btnKunciLayar = findViewById(R.id.btnKunciLayar);
        btnLampu = findViewById(R.id.btnLampu);
        btnSuara = findViewById(R.id.btnSuara);
        btnMenuApk = findViewById(R.id.btnMenuApk);
        btnKamera = findViewById(R.id.btnKamera);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnGame = findViewById(R.id.btnGame);

        btnBack.setOnClickListener(v -> finish());

        device1.setOnClickListener(v ->
            Toast.makeText(this, "OPPO A16 - Kontrol", Toast.LENGTH_SHORT).show());

        device2.setOnClickListener(v ->
            Toast.makeText(this, "VIVO Y21 - Kontrol", Toast.LENGTH_SHORT).show());

        device3.setOnClickListener(v ->
            Toast.makeText(this, "REALME C25 - Offline", Toast.LENGTH_SHORT).show());

        btnKunciLayar.setOnClickListener(v ->
            Toast.makeText(this, "Kunci Layar", Toast.LENGTH_SHORT).show());

        btnLampu.setOnClickListener(v ->
            Toast.makeText(this, "Lampu Nyala", Toast.LENGTH_SHORT).show());

        btnSuara.setOnClickListener(v ->
            Toast.makeText(this, "Tambah Suara", Toast.LENGTH_SHORT).show());

        btnMenuApk.setOnClickListener(v ->
            Toast.makeText(this, "Menu APK", Toast.LENGTH_SHORT).show());

        btnKamera.setOnClickListener(v ->
            Toast.makeText(this, "Kamera", Toast.LENGTH_SHORT).show());

        btnWhatsapp.setOnClickListener(v ->
            Toast.makeText(this, "Kontrol WA", Toast.LENGTH_SHORT).show());

        btnGame.setOnClickListener(v ->
            Toast.makeText(this, "Cek Game", Toast.LENGTH_SHORT).show());
    }
}