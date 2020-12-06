package com.example.visualcoding.objects.drawables;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.visualcoding.objects.drawables.Drawable;

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
