package com.example.den.lesson2.Items;


public class ItemGallery extends ItemBase {

    private int imgResoureID;

    public ItemGallery(int imgResoureID) {
        this.imgResoureID = imgResoureID;
    }

    public int imgResoureID(){
        return this.imgResoureID;
    }
}
