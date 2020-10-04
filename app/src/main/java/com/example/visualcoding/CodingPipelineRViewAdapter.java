package com.example.visualcoding;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.visualcoding.game_objects.CodeObject;
import java.util.ArrayList;

public class CodingPipelineRViewAdapter extends RecyclerView.Adapter<ListLineHolder> {
    private Context context;
    private ArrayList<CodeObject> localList;
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
        LinearLayout layout = holder.getLineView().findViewById(R.id.pipeline_recycler_view_item_linear_layout);

        TextView textView = (TextView) holder.getLineView().findViewById(R.id.pipeline_recycler_view_item_name);
        textView.setText(localList.get(position).toString());

        ((TextView)holder.getLineView().findViewById(R.id.pipeline_condition_lhs)).setText("LHS");
        ((TextView)holder.getLineView().findViewById(R.id.pipeline_condition_operation)).setText(">=");
        ((TextView)holder.getLineView().findViewById(R.id.pipeline_condition_rhs)).setText("RHS");
    }

    private View.OnClickListener getNewListener(final Handler handler) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.obtainMessage(0, v).sendToTarget();
            }
        };
    }

    public void addItem(CodeObject object) {
        localList.add(object);
    }

    public void removeItem(int position) {
        localList.remove(position);
    }

    @NonNull
    @Override
    public ListLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pipeline_recycler_view_item, parent, false);

        // v.setOnClickListener(navViewListener);
        ListLineHolder listLine = new ListLineHolder(v);
        return listLine;
    }

    public void clear() {
        localList.clear();
    }

}
