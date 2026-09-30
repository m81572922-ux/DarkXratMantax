package com.darkxrat.mantax;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ToolsActivity extends AppCompatActivity {

    ImageView btnBack;
    LinearLayout toolTiktok, toolInstagram, toolAnime, toolIphoneQuote, toolOsint, toolUtilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        btnBack = findViewById(R.id.btnBack);
        toolTiktok = findViewById(R.id.toolTiktok);
        toolInstagram = findViewById(R.id.toolInstagram);
        toolAnime = findViewById(R.id.toolAnime);
        toolIphoneQuote = findViewById(R.id.toolIphoneQuote);
        toolOsint = findViewById(R.id.toolOsint);
        toolUtilities = findViewById(R.id.toolUtilities);

        btnBack.setOnClickListener(v -> finish());

        toolTiktok.setOnClickListener(v ->
            Toast.makeText(this, "TikTok Download", Toast.LENGTH_SHORT).show());

        toolInstagram.setOnClickListener(v ->
            Toast.makeText(this, "Instagram Download", Toast.LENGTH_SHORT).show());

        toolAnime.setOnClickListener(v ->
            Toast.makeText(this, "Anime Play", Toast.LENGTH_SHORT).show());

        toolIphoneQuote.setOnClickListener(v ->
            Toast.makeText(this, "iPhone Quote Chat", Toast.LENGTH_SHORT).show());

        toolOsint.setOnClickListener(v ->
            Toast.makeText(this, "OSINT Deep Search", Toast.LENGTH_SHORT).show());

        toolUtilities.setOnClickListener(v ->
            Toast.makeText(this, "Utilities", Toast.LENGTH_SHORT).show());
    }
}