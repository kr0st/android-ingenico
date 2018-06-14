package com.example.den.lesson3;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by den on 3/25/18.
 */

public class Car {
    String name;
    Drawable carImageDrawable;

    public Car(String name, Drawable carImage) {
        this.name = name;
        this.carImageDrawable = carImage;
    }
}
