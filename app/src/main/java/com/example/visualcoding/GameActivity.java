package com.example.visualcoding;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visualcoding.game_objects.Condition;
import com.example.visualcoding.game_objects.ConditionOperationType;
import com.example.visualcoding.game_objects.IntParam;
import com.example.visualcoding.game_objects.WhileLoop;

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
        codePipelineRView.setLayoutManager(new LinearLayoutManager(GameActivity.this, RecyclerView.VERTICAL, false));

        final Button whileLoop = findViewById(R.id.while_loop);
        Button forLoop = findViewById(R.id.for_loop);
        Button ifStatement = findViewById(R.id.if_statement);
        View.OnClickListener listener =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;

                WhileLoop whileLoop1 = new WhileLoop("WHILE1");
                whileLoop1.setLoopCondition(new Condition(new IntParam(2),
                                            ConditionOperationType.GREATER_THAN,
                                            new IntParam(5)));

                System.out.println("WHILE EVAL: "+ whileLoop1.evaluate());

                pipelineAdapter.addItem(whileLoop1);
                pipelineAdapter.notifyDataSetChanged();
            }
        };

       whileLoop.setOnClickListener(listener);
       forLoop.setOnClickListener(listener);
       ifStatement.setOnClickListener(listener);
    }
}