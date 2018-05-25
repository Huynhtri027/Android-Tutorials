package com.example.keremoflu.lottie;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Shared extends AppCompatActivity {

    private ImageView image1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        //
        image1 = findViewById(R.id.image1);
        textView = findViewById(R.id.text1);
        //

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shared.this, Shared2.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(image1, "transition_image");
                pairs[1] = new Pair<View, String>(textView, "transition_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Shared.this, pairs);
                startActivity(intent, options.toBundle());
                
                //When user clicked image1 imageView, image and textview will be moved pairly
                // 1- In both activities image1 and textview xml, should include 'android:transitionName="transition_image"'
            }
        });
    }
}
