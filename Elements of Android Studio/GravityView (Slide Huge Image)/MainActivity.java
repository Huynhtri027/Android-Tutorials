package com.example.kerem.gravityview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import co.gofynd.gravityview.GravityView;

public class MainActivity extends AppCompatActivity {

    GravityView gravityView;
    ImageView image_background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_background = (ImageView) findViewById(R.id.image_background);
        gravityView = GravityView.getInstance(this);
        if (!gravityView.deviceSupported()) {
            Toast.makeText(this, "device not support", Toast.LENGTH_SHORT).show();
            return;
        } else {
            gravityView.setImage(image_background, R.drawable.cityphoto).center();

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }
}
