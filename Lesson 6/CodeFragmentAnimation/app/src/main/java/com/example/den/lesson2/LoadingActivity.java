package com.example.den.lesson2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.den.lesson2.Data.DataManager;
import com.example.den.lesson2.Items.ItemArticle;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
        client.get("https://meduza.io/api/v3/search?chrono=news&locale=ru&page=0&per_page=24", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                DataManager.instance.setItemsArticle(parseMeduzaArticlesFromByte(responseBody));
                startActivity(homeActivity);
                closeActivity();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                failedDialog.show();
            }
        });
    }

    private ItemArticle[] parseLentaArticlesFromByte(byte[] responseBody) {

        ArrayList<ItemArticle> itemsArray = new ArrayList<>();

        try {
            String strJson = new String(responseBody, "UTF-8");
            JSONObject jObject = new JSONObject(strJson);
            JSONArray jArray = jObject.getJSONArray("headlines");
            for (int i=0; i < jArray.length(); i++) {
                JSONObject rootObject = jArray.getJSONObject(i);
                if(rootObject.has("info")) {
                    JSONObject infoObject = rootObject.getJSONObject("info");
                    if(infoObject != null) {
                        String title = infoObject.get("title").toString();
                        String description = infoObject.get("rightcol").toString();
                        ItemArticle itemArticle = new ItemArticle(title, description);
                        itemsArray.add(itemArticle);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return itemsArray.toArray(new ItemArticle[itemsArray.size()]);
    }

    private ItemArticle[] parseMeduzaArticlesFromByte(byte[] responseBody) {

        ArrayList<ItemArticle> itemsArray = new ArrayList<>();

        try {
            String strJson = new String(responseBody, "UTF-8");
            JSONObject jObject = new JSONObject(strJson);
            JSONArray collection = jObject.getJSONArray("collection");
            JSONObject documents = jObject.getJSONObject("documents");
            for (int i=0; i < collection.length(); i++) {
                String collectionObject = collection.get(i).toString();

                JSONObject rootObject = documents.getJSONObject(collectionObject);
                String title = rootObject.get("title").toString();
                String description = rootObject.get("url").toString();

                ItemArticle itemArticle = new ItemArticle(title, description);
                itemsArray.add(itemArticle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemsArray.toArray(new ItemArticle[itemsArray.size()]);
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
