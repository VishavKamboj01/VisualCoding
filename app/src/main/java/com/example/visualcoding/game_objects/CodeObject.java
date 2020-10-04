package com.example.visualcoding.game_objects;

import androidx.annotation.NonNull;

public abstract class CodeObject {
    private String id;
    public CodeObject(String id) {
        this.id = id;
    }

    public boolean evaluate(){
        return false;
    }

    @NonNull
    @Override
    public String toString() {
        return id;
    }
}
