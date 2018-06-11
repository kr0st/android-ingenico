package com.example.den.lesson2;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    public static String EMAIL_EXTRA_KEY = "EMAIL_EXTRA_KEY";
    public static String PASSWORD_EXTRA_KEY = "PASSWORD_EXTRA_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupActivity();
    }

    private void setupActivity() {
        String email = getIntent().getStringExtra(EMAIL_EXTRA_KEY);
        String password = getIntent().getStringExtra(PASSWORD_EXTRA_KEY);

        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewPassword = findViewById(R.id.textViewPassword);

        textViewEmail.setText(email);
        textViewPassword.setText(password);
    }
}
