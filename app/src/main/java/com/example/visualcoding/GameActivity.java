package com.example.visualcoding;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        final Button whileLoop = findViewById(R.id.while_loop);
        Button forLoop = findViewById(R.id.for_loop);
        Button ifStatement = findViewById(R.id.if_statement);
        whileLoop.setTag("WhileTag");

        codePipelineRView.setOnDragListener(new MyDragEventListener());

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

        whileLoop.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // Create a new ClipData.
                // This is done in two steps to provide clarity. The convenience method
                // ClipData.newPlainText() can create a plain text ClipData in one step.

                // Create a new ClipData.Item from the Button object's tag
                ClipData.Item item = new ClipData.Item(view.getTag().toString());

                // Create a new ClipData using the tag as a label, the plain text MIME type, and
                // the already-created item. This will create a new ClipDescription object within the
                // ClipData, and set its MIME type entry to "text/plain"
                ClipData dragData = new ClipData(
                        view.getTag().toString(),
                        new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
                        item);

                // Instantiates the drag shadow builder.
                View.DragShadowBuilder myShadow = new MyDragShadowBuilder(whileLoop);

                // Starts the drag

//                view.startDrag(dragData,  // the data to be dragged
//                        myShadow,  // the drag shadow builder
//                        null,      // no need to use local data
//                        0          // flags (not currently used, set to 0)
//                );
                view.startDragAndDrop(dragData, myShadow, null, 0);
                return false;
            }
        });

        whileLoop.setOnDragListener(new MyDragEventListener());

    }
    class MyDragEventListener implements View.OnDragListener {
        public String dragData;

        // This is the method that the system calls when it dispatches a drag event to the
        // listener.
        public boolean onDrag(View v, DragEvent event) {

            // Defines a variable to store the action type for the incoming event
            final int action = event.getAction();

            // Handles each of the expected events
            switch(action) {

                case DragEvent.ACTION_DRAG_STARTED:

                    // Determines if this View can accept the dragged data
                    if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                        // As an example of what your application might do,
                        // applies a blue color tint to the View to indicate that it can accept
                        // data.


                        // Invalidate the view to force a redraw in the new tint
                        v.invalidate();

                        // returns true to indicate that the View can accept the dragged data.
                        return true;

                    }

                    // Returns false. During the current drag and drop operation, this View will
                    // not receive events again until ACTION_DRAG_ENDED is sent.
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:

                    // Applies a green tint to the View. Return true; the return value is ignored.

                    // Invalidate the view to force a redraw in the new tint
                    v.invalidate();

                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:

                    // Ignore the event
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:

                    // Re-sets the color tint to blue. Returns true; the return value is ignored.

                    // Invalidate the view to force a redraw in the new tint
                    v.invalidate();

                    return true;

                case DragEvent.ACTION_DROP:

                    // Gets the item containing the dragged data
                    ClipData.Item item = event.getClipData().getItemAt(0);

                    // Gets the text data from the item.
                    dragData = item.getText().toString();

                    // Displays a message containing the dragged data.
                    Toast.makeText(GameActivity.this, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();

                    // Turns off any color tints

                    // Invalidates the view to force a redraw
                    v.invalidate();

                    // Returns true. DragEvent.getResult() will return true.
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:

                    // Turns off any color tinting

                    // Invalidates the view to force a redraw
                    v.invalidate();

                    // Does a getResult(), and displays what happened.
                    if (event.getResult()) {
                        Toast.makeText(GameActivity.this, "The drop was handled.", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(GameActivity.this, "The drop didn't work.", Toast.LENGTH_LONG).show();

                    }

                    // returns true; the value is ignored.
                    return true;

                // An unknown action type was received.
                default:
                    break;
            }

            return false;
        }
    };
}