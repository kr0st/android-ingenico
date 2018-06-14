package com.example.den.lesson2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        String email = getIntent().getStringExtra(HomeActivity.EMAIL_EXTRA_KEY);
        String password = getIntent().getStringExtra(HomeActivity.PASSWORD_EXTRA_KEY);

        final Intent homeActivity = new Intent(this, HomeActivity.class);

        homeActivity.putExtra(HomeActivity.EMAIL_EXTRA_KEY, email);
        homeActivity.putExtra(HomeActivity.PASSWORD_EXTRA_KEY, password);

        final AlertDialog failedDialog = composeDialogFailer();

        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://ptsv2.com/t/enj4c-1528743957/post", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                startActivity(homeActivity);
                closeActivity();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                failedDialog.show();
            }
        });
    }

    private AlertDialog composeDialogFailer() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Something went wrong, try again!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        closeActivity();
                    }
                });
        return builder.create();
    }

    private void closeActivity() {
        this.finish();
    }
}
