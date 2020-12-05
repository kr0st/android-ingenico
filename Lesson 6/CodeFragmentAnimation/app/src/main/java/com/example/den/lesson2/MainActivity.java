package com.example.den.lesson2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoginClick(View view) {
        openHomeActivity();
    }

    private void openHomeActivity() {
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        Intent loadingActivity = new Intent(this, LoadingActivity.class);

        loadingActivity.putExtra(HomeActivity.EMAIL_EXTRA_KEY, email);
        loadingActivity.putExtra(HomeActivity.PASSWORD_EXTRA_KEY, password);

        startActivity(loadingActivity);

        writeToSharedPreferences();
        readFromSharedPreferences();
    }

    private void writeToSharedPreferences() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("user_score", 10);
        editor.apply();
    }

    private void readFromSharedPreferences() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int defaultValue = -1;
        int highScore = sharedPref.getInt("user_score", defaultValue);
        Log.v("",highScore + "");
    }
}
