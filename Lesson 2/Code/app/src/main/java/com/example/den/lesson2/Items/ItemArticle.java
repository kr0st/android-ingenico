package com.example.den.lesson2.Items;

public class ItemArticle extends ItemBase{

    private String title;
    private String description;

    public ItemArticle(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }
}
