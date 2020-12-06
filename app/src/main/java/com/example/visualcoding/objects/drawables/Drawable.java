package com.example.visualcoding.objects.drawables;

import android.graphics.Canvas;

public abstract class Drawable {
    private Material material;
    public Drawable() {

    }

    public Material getMaterial() {
        return material;
    }

    public Drawable setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public abstract void draw(Canvas canvas);
}
