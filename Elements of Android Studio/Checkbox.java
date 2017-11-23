package com.example.kerem.basicfunctions_numberpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox_male, checkBox_female;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        checkBox_male = (CheckBox)findViewById(R.id.checkBox_male);
        checkBox_female = (CheckBox)findViewById(R.id.checkBox_female);


        //MALE
        checkBox_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_male.isChecked()) {

                    Toast.makeText(MainActivity.this,
                            "Male checked",
                            Toast.LENGTH_SHORT)
                            .show();
                }else{
                    Toast.makeText(MainActivity.this,
                            "Male unchecked",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        //FEMALE
        checkBox_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox_female.isChecked()) {

                    Toast.makeText(MainActivity.this,
                            "Female checked",
                            Toast.LENGTH_SHORT)
                            .show();
                }else{
                    Toast.makeText(MainActivity.this,
                            "Female unchecked",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });


    }

    
    //MULTICHOICE CHECKBOX
    /* To use multichoice option, you should;
        1- define "onClick" as "checkboxMulti" in CheckBoxes' in XML file
        2- disable setOnClickListeners

     */
    public void checkboxMulti(View v){

        if(checkBox_male.isChecked() && checkBox_female.isChecked()){
            textView.setText("Both checked");
        }

    }

}
