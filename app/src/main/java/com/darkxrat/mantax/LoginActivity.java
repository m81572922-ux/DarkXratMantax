package com.darkxrat.mantax;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.darkxrat.mantax.database.UserDao;
import com.darkxrat.mantax.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin, btnBeliAkses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnBeliAkses = findViewById(R.id.btnBeliAkses);

        btnLogin.setOnClickListener(v -> {
            String user = etUsername.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                showError();
                return;
            }

            UserDao dao = new UserDao(this);
            User u = dao.login(user, pass);

            if (u == null) {
                showError();
                return;
            }

            if (!u.getRole().equals("MANZXRAT")) {
                if (isExpired(u.getExpired())) {
                    Toast.makeText(this, "AKUN EXPIRED!", Toast.LENGTH_LONG).show();
                    dao.deleteUser(u.getId());
                    showError();
                    return;
                }
            }

            SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
            sp.edit()
                .putString("username", u.getUsername())
                .putString("role", u.getRole())
                .putString("expired", u.getExpired())
                .putBoolean("isLogin", true)
                .apply();

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        });

        // BELI AKSES → TELEGRAM
        btnBeliAkses.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/Rohmanzz"));
            startActivity(i);
        });
    }

    private boolean isExpired(String expired) {
        if (expired == null || expired.equals("PERMANEN")) return false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date dateExpired = sdf.parse(expired);
            return new Date().after(dateExpired);
        } catch (Exception e) {
            return false;
        }
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
            finishAffinity();
        });
    }
}