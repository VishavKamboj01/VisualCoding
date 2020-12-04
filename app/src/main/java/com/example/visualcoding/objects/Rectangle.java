package com.example.visualcoding.objects;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Rectangle extends Drawable {
    private Rect rectangle;
    public Rectangle(Rect rect) {
        this.rectangle = rect;
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(rectangle, getMaterial().getColor("color1"));
    }

    public Rect getRectangle() {
        return rectangle;
    }
}
