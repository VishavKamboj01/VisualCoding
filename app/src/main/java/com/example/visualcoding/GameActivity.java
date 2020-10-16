package com.example.visualcoding;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visualcoding.adapter.CodingPipelineRViewAdapter;
import com.example.visualcoding.modal.CodeObject;

public class GameActivity extends AppCompatActivity {
    private RecyclerView codePipelineRView;
    private CodingPipelineRViewAdapter pipelineAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        codePipelineRView = findViewById(R.id.code_pipeline_r_view);
        pipelineAdapter = new CodingPipelineRViewAdapter(GameActivity.this);
        codePipelineRView.setAdapter(pipelineAdapter);
        codePipelineRView.setLayoutManager(new LinearLayoutManager(GameActivity.this, RecyclerView.HORIZONTAL, false));

        Button whileLoop = findViewById(R.id.while_loop);
        Button forLoop = findViewById(R.id.for_loop);
        Button ifStatement = findViewById(R.id.if_statement);
        View.OnClickListener listener =  new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tview = (TextView)view;

            pipelineAdapter.addItem(new CodeObject(tview.getText().toString()));
            pipelineAdapter.notifyDataSetChanged();
        }
        };

       whileLoop.setOnClickListener(listener);
       forLoop.setOnClickListener(listener);
       ifStatement.setOnClickListener(listener);
    }
}