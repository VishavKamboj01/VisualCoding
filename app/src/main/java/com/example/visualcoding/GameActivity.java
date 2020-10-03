package com.example.visualcoding;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final LinearLayout ll = findViewById(R.id.test);

        Button click = findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = new Button(GameActivity.this);
                b.setText("NEW");
//                ViewGroup.LayoutParams params = b.getLayoutParams();
//                params.width = 100;
//                params.height = 100;
                ll.addView(b);
            }
        });
    }
}