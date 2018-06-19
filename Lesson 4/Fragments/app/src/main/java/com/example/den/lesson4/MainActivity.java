package com.example.den.lesson4;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ExampleFragment.OnFragmentInteractionListener, PlusOneFragment.OnFragmentInteractionListener2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_2);

        addFragment1();
    }


    public void addFragment1() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ExampleFragment fragment = new ExampleFragment();
        fragmentTransaction.add(R.id.list, fragment);
        fragmentTransaction.commit();

    }

    public void addFragment2() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PlusOneFragment fragment = new PlusOneFragment();
        fragmentTransaction.add(R.id.list, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentInteraction(int number) {
        int a = number;
        addFragment2();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code
            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onFragmentInteraction2(Uri uri) {
        Log.v("","");
    }
}
