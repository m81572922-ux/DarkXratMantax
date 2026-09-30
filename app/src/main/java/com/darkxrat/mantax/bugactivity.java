package com.darkxrat.mantax;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BugActivity extends AppCompatActivity {

    ImageView btnBack;
    EditText etTarget;
    Spinner spinnerBug, spinnerFunc, spinnerSender;
    Button btnLaunch;

    // List bug
    String[] listBug = {
        "FORCLOSE IOS", "BLANK ANDRO", "DELAY ONE SHOT",
        "BULDO DELAY", "DELAY", "BLANK GROUP",
        "FC INVISIBLE HARD", "DELAY INVISIBLE",
        "BLANK X DELAY INVISIBLE", "FC IOS INVISIBLE",
        "CRASH HARD", "DELAY INVISIBLE 2"
    };

    // List func bug
    String[] listFunc = {
        "FUNC DEFAULT", "FUNC HARD", "FUNC ULTRA",
        "FUNC GACOR", "FUNC INVISIBLE"
    };

    // List sender (nanti dinamis dari database)
    String[] listSender = {
        "PRIVATE (Kosong)", "GLOBAL (1 sender)"
    };

    // Cooldown 10 detik
    boolean isCooldown = false;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);

        btnBack = findViewById(R.id.btnBack);
        etTarget = findViewById(R.id.etTarget);
        spinnerBug = findViewById(R.id.spinnerBug);
        spinnerFunc = findViewById(R.id.spinnerFunc);
        spinnerSender = findViewById(R.id.spinnerSender);
        btnLaunch = findViewById(R.id.btnLaunch);

        // Setup spinner bug
        ArrayAdapter<String> adapterBug = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, listBug);
        spinnerBug.setAdapter(adapterBug);

        // Setup spinner func
        ArrayAdapter<String> adapterFunc = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, listFunc);
        spinnerFunc.setAdapter(adapterFunc);

        // Setup spinner sender
        ArrayAdapter<String> adapterSender = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, listSender);
        spinnerSender.setAdapter(adapterSender);

        // Tombol back
        btnBack.setOnClickListener(v -> finish());

        // Tombol kirim
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

            // Kirim bug (via WA sender)
            kirimBug(target, bug, func, sender);

            // Cooldown 10 detik
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

    private void kirimBug(String target, String bug, String func, String sender) {
        // Logic kirim bug via WhatsApp sender
        // Nanti di-implement pake API WhatsApp / sender service
        Toast.makeText(this,
            "BUG TERKIRIM!\nTarget: " + target + "\nBug: " + bug + "\nFunc: " + func,
            Toast.LENGTH_LONG).show();
    }
}