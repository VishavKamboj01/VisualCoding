package com.example.visualcoding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visualcoding.R;

import java.util.ArrayList;

import com.example.visualcoding.modal.CodeObject;

public class CodingPipelineRViewAdapter extends RecyclerView.Adapter<ListLineHolder> {
    private Context context;
    private ArrayList<CodeObject> localList;

    public CodingPipelineRViewAdapter(Context context) {
        this.context = context;
        localList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return localList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ListLineHolder holder, int position) {
        TextView code = holder.getLineView().findViewById(R.id.codeLine);
        code.setText(localList.get(position).getCode());
    }

    public void addItem(CodeObject codeObject) {
        localList.add(codeObject);
    }

    public void removeItem(int position) {
        localList.remove(position);
    }

    @NonNull
    @Override
    public ListLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.code_block, parent, false);
        return new ListLineHolder(v);
    }

    public void clear() {
        localList.clear();
    }
}
