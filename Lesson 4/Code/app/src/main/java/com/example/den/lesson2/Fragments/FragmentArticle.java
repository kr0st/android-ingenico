package com.example.den.lesson2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.den.lesson2.Data.DataManager;
import com.example.den.lesson2.Items.ItemArticle;
import com.example.den.lesson2.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;


public class FragmentArticle extends Fragment {

    public ItemArticle itemArticle;

    public FragmentArticle() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("notes", "Test api support");
            StringEntity entity = new StringEntity(jsonParams.toString());
            AsyncHttpClient client = new AsyncHttpClient();
            client.post(getContext(), "http://ptsv2.com/t/iihvv-1529357275/post", entity, "application/json",
                    new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_article, container, false);
        setupView(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setupView(View view) {

        if(itemArticle == null) {
            return;
        }

        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewDescription = view.findViewById(R.id.textViewDescription);

        textViewTitle.setText(itemArticle.getTitle());
        textViewDescription.setText(itemArticle.getDescription());
    }
}
