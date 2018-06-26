package com.example.den.lesson2.Items;

public class ItemBase {

    public static boolean isArticle(ItemBase item) {
        return item.getClass().equals(ItemArticle.class);
    }

    public static boolean isGallery(ItemBase item) {
        return item.getClass().equals(ItemGallery.class);
    }
}
