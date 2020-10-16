package com.example.visualcoding.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.visualcoding.R;

public class ListLineHolder extends RecyclerView.ViewHolder {
    private View view;
    public ListLineHolder(View v) {
        super(v);
        this.view = v;
    }

    public View getLineView(){
        return this.view;
    }

}
