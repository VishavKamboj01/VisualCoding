package com.example.visualcoding;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CodingPipelineRViewAdapter extends RecyclerView.Adapter<ListLineHolder> {
    private Context context;
    private ArrayList<String> localList;
    private View.OnClickListener navViewListener;

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
        TextView textView = (TextView) holder.getLineView();
        textView.setText(localList.get(position));
    }

    private View.OnClickListener getNewListener(final Handler handler) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.obtainMessage(0, v).sendToTarget();
            }
        };
    }

    public void addItem(String string) {
        localList.add(string);
    }

    public void removeItem(int position) {
        localList.remove(position);
    }

    @NonNull
    @Override
    public ListLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        v.setOnClickListener(navViewListener);
        ListLineHolder listLine = new ListLineHolder(v);
        return listLine;
    }

    public void clear() {
        localList.clear();
    }

}
