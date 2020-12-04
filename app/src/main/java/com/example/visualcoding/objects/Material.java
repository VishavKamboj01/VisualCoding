package com.example.visualcoding.objects;

import android.graphics.Paint;
import java.util.HashMap;

public class Material {
    private HashMap<String, Paint> colors;
    public Material() {
        colors = new HashMap<>();
    }

    public Material addColor(String tag, Paint color) {
        this.colors.put(tag, color);
        return this;
    }

    public Paint getColor(String tag) {
        return colors.get(tag);
    }
}
