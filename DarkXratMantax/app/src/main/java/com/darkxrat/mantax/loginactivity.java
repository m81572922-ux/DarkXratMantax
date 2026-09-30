package com.darkxrat.mantax;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    // Kredensial khusus MANZXRAT (lo)
    private static final String OWNER_USER = "MANZZ";
    private static final String OWNER_PASS = "STOKMAN2011";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String user = etUsername.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                showError();
                return;
            }

            // Cek login
            if (user.equals(OWNER_USER) && pass.equals(OWNER_PASS)) {
                // Login sukses sebagai MANZXRAT
                SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
                sp.edit()
                    .putString("username", user)
                    .putString("role", "MANZXRAT")
                    .putBoolean("isLogin", true)
                    .apply();

                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                showError();
            }
        });
    }

    private void showError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_DarkXratMantax);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_error, null);
        builder.setView(view);
        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnTutup = view.findViewById(R.id.btnTutup);
        btnTutup.setOnClickListener(v -> {
            dialog.dismiss();
            finishAffinity(); // Keluar dari app
        });
    }
}