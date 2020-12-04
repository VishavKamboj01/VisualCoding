package com.example.visualcoding.ui.activities;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.visualcoding.R;
import com.example.visualcoding.ui.helpers.CodeObjectDragEventListener;
import com.example.visualcoding.ui.helpers.DragShadowBuilder;

public class GameActivity extends AppCompatActivity {
    // private RecyclerView codePipelineRView;
    //private CodingPipelineRViewAdapter pipelineAdapter;
    private CodeMapDrawingSurface codeMapDrawingSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // codePipelineRView = findViewById(R.id.code_pipeline_r_view);
//        pipelineAdapter = new CodingPipelineRViewAdapter(GameActivity.this);
//        codePipelineRView.setAdapter(pipelineAdapter);
//        codePipelineRView.setLayoutManager(new LinearLayoutManager(GameActivity.this, RecyclerView.HORIZONTAL, false));

        codeMapDrawingSurface = findViewById(R.id.code_map_drawing_surface);
        final Button whileLoop = findViewById(R.id.while_loop);
        Button forLoop = findViewById(R.id.for_loop);
        Button ifStatement = findViewById(R.id.if_statement);
        whileLoop.setTag("WhileTag");

        //codePipelineRView.setOnDragListener(new MyDragEventListener());

        View.OnClickListener listener =  new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tview = (TextView)view;

//            pipelineAdapter.addItem(new CodeObject(tview.getText().toString()));
//            pipelineAdapter.notifyDataSetChanged();
        }
        };

       whileLoop.setOnClickListener(listener);
       forLoop.setOnClickListener(listener);
       ifStatement.setOnClickListener(listener);

        whileLoop.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // Create a new ClipData.
                // This is done in two steps to provide clarity. The convenience method
                // ClipData.newPlainText() can create a plain text ClipData in one step.

                // Create a new ClipData.Item from the Button object's tag
                ClipData.Item item = new ClipData.Item(view.getTag().toString());

                ClipData dragData = new ClipData(
                        view.getTag().toString(),
                        new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
                        item);

                // Instantiates the drag shadow builder.
                View.DragShadowBuilder myShadow = new DragShadowBuilder(whileLoop);

                view.startDragAndDrop(dragData, myShadow, null, 0);
                return false;
            }
        });

        whileLoop.setOnDragListener(new CodeObjectDragEventListener(this));
    }

    @Override
    protected void onPause() {
        codeMapDrawingSurface.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        codeMapDrawingSurface.resume();
    }
}




