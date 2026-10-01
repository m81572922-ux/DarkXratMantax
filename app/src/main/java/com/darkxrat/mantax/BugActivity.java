package com.darkxrat.mantax;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class BugActivity extends AppCompatActivity {

    ImageView btnBack;
    VideoView videoBug;
    EditText etTarget;
    Spinner spinnerBug, spinnerFunc, spinnerSender;
    Button btnLaunch;
    TextView tvSenderStatus, tvSenderBadge, tvSenderCount;

    String[] listBug = {
        "FORCLOSE IOS", "BLANK ANDRO", "DELAY ONE SHOT",
        "BULDO DELAY", "DELAY", "BLANK GROUP",
        "FC INVISIBLE HARD", "DELAY INVISIBLE",
        "BLANK X DELAY INVISIBLE", "FC IOS INVISIBLE",
        "CRASH HARD", "DELAY INVISIBLE 2"
    };

    String[] listFunc = {
        "FUNC DEFAULT", "FUNC HARD", "FUNC ULTRA",
        "FUNC GACOR", "FUNC INVISIBLE"
    };

    String[] listSender = {
        "PRIVATE (Kosong)", "GLOBAL (1 sender)"
    };

    boolean isCooldown = false;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);

        btnBack = findViewById(R.id.btnBack);
        videoBug = findViewById(R.id.videoBug);
        etTarget = findViewById(R.id.etTarget);
        spinnerBug = findViewById(R.id.spinnerBug);
        spinnerFunc = findViewById(R.id.spinnerFunc);
        spinnerSender = findViewById(R.id.spinnerSender);
        btnLaunch = findViewById(R.id.btnLaunch);
        tvSenderStatus = findViewById(R.id.tvSenderStatus);
        tvSenderBadge = findViewById(R.id.tvSenderBadge);
        tvSenderCount = findViewById(R.id.tvSenderCount);

        // VIDEO BANNER
        String path = "android.resource://" + getPackageName() + "/" + R.raw.intro_anime;
        videoBug.setVideoURI(Uri.parse(path));
        videoBug.start();
        videoBug.setOnPreparedListener(mp -> {
            mp.setLooping(true);
            mp.setVolume(0, 0);
        });

        // SETUP SPINNER
        ArrayAdapter<String> adapterBug = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, listBug);
        spinnerBug.setAdapter(adapterBug);

        ArrayAdapter<String> adapterFunc = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, listFunc);
        spinnerFunc.setAdapter(adapterFunc);

        ArrayAdapter<String> adapterSender = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, listSender);
        spinnerSender.setAdapter(adapterSender);

        // TOMBOL BACK
        btnBack.setOnClickListener(v -> finish());

        // TOMBOL KIRIM
        btnLaunch.setOnClickListener(v -> {
            if (isCooldown) {
                Toast.makeText(this, "Tunggu 10 detik dulu!", Toast.LENGTH_SHORT).show();
                return;
            }

            String target = etTarget.getText().toString().trim();
            if (target.isEmpty()) {
                Toast.makeText(this, "Isi nomor target dulu!", Toast.LENGTH_SHORT).show();
                return;
            }

            String bug = spinnerBug.getSelectedItem().toString();
            String func = spinnerFunc.getSelectedItem().toString();
            String sender = spinnerSender.getSelectedItem().toString();

            Toast.makeText(this,
                "BUG TERKIRIM!\nTarget: " + target + "\nBug: " + bug,
                Toast.LENGTH_LONG).show();

            isCooldown = true;
            btnLaunch.setEnabled(false);
            btnLaunch.setText("COOLDOWN 10s...");

            handler.postDelayed(() -> {
                isCooldown = false;
                btnLaunch.setEnabled(true);
                btnLaunch.setText("🚀 LAUNCH ATTACK");
            }, 10000);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoBug != null) {
            videoBug.stopPlayback();
        }
    }
}