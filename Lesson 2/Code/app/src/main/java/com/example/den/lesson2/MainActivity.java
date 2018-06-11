package com.example.den.lesson2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private AlertDialog loadingAlertDialog;

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

        final Intent homeActivity = new Intent(this, HomeActivity.class);

        homeActivity.putExtra(HomeActivity.EMAIL_EXTRA_KEY, email);
        homeActivity.putExtra(HomeActivity.PASSWORD_EXTRA_KEY, password);

        showLoadingAlert();

        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://ptsv2.com/t/enj4c-1528743957/post", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(loadingAlertDialog != null) {
                    loadingAlertDialog.dismiss();
                }

                startActivity(homeActivity);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.v("","");
            }
        });
    }

    private void showLoadingAlert() {
        loadingAlertDialog = new AlertDialog.Builder(this).create();
        loadingAlertDialog.setTitle("Please wait");
        loadingAlertDialog.setMessage("Logging in");
        loadingAlertDialog.setCancelable(false);
        loadingAlertDialog.show();
    }
}
