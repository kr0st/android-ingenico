package com.example.den.lesson2;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.den.lesson2.Data.DataManager;
import com.example.den.lesson2.Fragments.FragmentArticle;
import com.example.den.lesson2.Fragments.FragmentHome;
import com.example.den.lesson2.Items.ItemArticle;
import com.example.den.lesson2.Items.ItemBase;
import com.example.den.lesson2.Items.ItemGallery;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.den.lesson2.Items.ItemBase.isArticle;
import static com.example.den.lesson2.Items.ItemBase.isGallery;


public class HomeActivity extends AppCompatActivity implements FragmentHome.OnHomeFragmentListener {

    public static String EMAIL_EXTRA_KEY = "EMAIL_EXTRA_KEY";
    public static String PASSWORD_EXTRA_KEY = "PASSWORD_EXTRA_KEY";

    private ItemBase[] itemsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupData();
        setupHomeFragment();
    }

    private void setupData() {
        ArrayList<ItemBase> items = new ArrayList<>(Arrays.asList(DataManager.instance.getItemsArticle()));
        items.add(new ItemGallery(R.drawable.sedan));
        items.add(new ItemGallery(R.drawable.convertible));
        items.add(new ItemGallery(R.drawable.convertible));
        this.itemsArray = items.toArray(new ItemBase[items.size()]);
    }

    private void setupHomeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentHome fragment = new FragmentHome();
        fragment.itemsArray = itemsArray;
        fragmentTransaction.add(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void setupFragmentArticle(ItemArticle item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentArticle fragment = new FragmentArticle();
        fragment.itemArticle = item;
        fragmentTransaction.add(R.id.frameLayout, fragment, "articleFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onFragmentInteraction(int position) {
        // Generate a message based on the position
        if (isArticle(itemsArray[position])) {
            ItemArticle article = (ItemArticle) itemsArray[position];
            setupFragmentArticle(article);
        } else if (isGallery(itemsArray[position])) {
            Intent galleryActivity = new Intent(this, GalleryActivity.class);
            startActivity(galleryActivity);
        }
    }
}
