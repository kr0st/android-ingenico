package com.example.den.lesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {

    public static String TITLE_EXTRA_KEY = "TITLE_EXTRA_KEY";
    public static String DESCRIPTION_EXTRA_KEY = "DESCRIPTION_EXTRA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewDescription = findViewById(R.id.textViewDescription);

        String title = getIntent().getStringExtra(TITLE_EXTRA_KEY);
        String description = getIntent().getStringExtra(DESCRIPTION_EXTRA_KEY);

        textViewTitle.setText(title);
        textViewDescription.setText(description);

    }
}
