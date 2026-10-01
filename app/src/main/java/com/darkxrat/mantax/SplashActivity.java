package com.darkxrat.mantax;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    VideoView videoIntro;
    Button btnSkip;
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        videoIntro = findViewById(R.id.videoIntro);
        btnSkip = findViewById(R.id.btnSkip);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.intro_anime;
        videoIntro.setVideoURI(Uri.parse(path));
        videoIntro.start();

        videoIntro.setOnPreparedListener(mp -> {
            mp.setLooping(false);
            videoIntro.start();
        });

        videoIntro.setOnErrorListener((mp, what, extra) -> {
            goToWelcome();
            return true;
        });

        btnSkip.setOnClickListener(v -> {
            handler.removeCallbacks(runnable);
            goToWelcome();
        });

        runnable = this::goToWelcome;
        handler.postDelayed(runnable, 10000);
    }

    private void goToWelcome() {
        startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}