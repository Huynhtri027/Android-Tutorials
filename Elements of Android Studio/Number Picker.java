package com.example.kerem.basicfunctions_numberpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    NumberPicker numberPicker;
    TextView textView_pickedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPicker = (NumberPicker)findViewById(R.id.numberPicker);
        textView_pickedNumber = (TextView) findViewById(R.id.textView_pickedNumber);

        //Custom String Picker
        final String[] colors = {"Red","Green","Blue","Yellow","Orange","Purple"};


        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(colors.length-1);
        numberPicker.setDisplayedValues(colors);
        numberPicker.setWrapSelectorWheel(true);

        //Get realtime value of NumberPicker
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView_pickedNumber.setText("Picked Number: "+colors[i1]);
            }
        });

       /* STANDART USE
        We set setMinValue and setMaxValue integer values and user picks
        */

       /* CUSTOM USE
            1- We declare String array like "colors"
            2- We set setMinValue and setMaxValue as "colors.length-1"
            3- Finally, we put "colors" values with "setDisplayedValues"
        */




    }
}
