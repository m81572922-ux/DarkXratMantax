package com.darkxrat.mantax;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SadapActivity extends AppCompatActivity {

    ImageView btnBack;
    EditText etTargetSadap;
    LinearLayout btnGetContact, btnStory, btnBugGroup;
    Spinner spinnerSenderSadap;
    Button btnLaunchSadap;

    String[] listSender = {
        "PRIVATE (Kosong)", "GLOBAL (1 sender)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadap);

        btnBack = findViewById(R.id.btnBack);
        etTargetSadap = findViewById(R.id.etTargetSadap);
        btnGetContact = findViewById(R.id.btnGetContact);
        btnStory = findViewById(R.id.btnStory);
        btnBugGroup = findViewById(R.id.btnBugGroup);
        spinnerSenderSadap = findViewById(R.id.spinnerSenderSadap);
        btnLaunchSadap = findViewById(R.id.btnLaunchSadap);

        // Setup spinner
        ArrayAdapter<String> adapterSender = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, listSender);
        spinnerSenderSadap.setAdapter(adapterSender);

        // Tombol back
        btnBack.setOnClickListener(v -> finish());

        // Tombol GetContact
        btnGetContact.setOnClickListener(v -> {
            Toast.makeText(this, "Fitur GetContact", Toast.LENGTH_SHORT).show();
        });

        // Tombol Story
        btnStory.setOnClickListener(v -> {
            Toast.makeText(this, "Fitur Story", Toast.LENGTH_SHORT).show();
        });

        // Tombol Bug Group
        btnBugGroup.setOnClickListener(v -> {
            Toast.makeText(this, "Fitur Bug Group", Toast.LENGTH_SHORT).show();
        });

        // Tombol Launch
        btnLaunchSadap.setOnClickListener(v -> {
            String target = etTargetSadap.getText().toString().trim();
            if (target.isEmpty()) {
                Toast.makeText(this, "Isi nomor target dulu!", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "SADAP TERKIRIM!\nTarget: " + target, Toast.LENGTH_LONG).show();
        });
    }
}