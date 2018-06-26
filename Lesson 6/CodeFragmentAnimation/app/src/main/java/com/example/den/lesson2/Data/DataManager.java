package com.example.den.lesson2.Data;

import com.example.den.lesson2.Items.ItemArticle;
import com.example.den.lesson2.Items.ItemBase;

public class DataManager {

    public static final DataManager instance = new DataManager();

    private ItemArticle[] itemsArticle;

    private DataManager() {}

    public void setItemsArticle(ItemArticle[] items) {
        this.itemsArticle = items;
    }
    public ItemBase[] getItemsArticle() {
        return itemsArticle;
    }
}
