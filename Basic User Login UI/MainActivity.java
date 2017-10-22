package com.example.kerem.loginscreen;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageview_logo;

    EditText editText_firstName,
             editText_lastName,
             editText_email,
             editText_password,
             editText_dateOfBirth,
             editText_idNumber;

    CheckBox checkBox;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview_logo = (ImageView) findViewById(R.id.imageview_logo);

        editText_firstName = (EditText) findViewById(R.id.editText_firstName);
        editText_lastName = (EditText) findViewById(R.id.editText_lastName);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_password = (EditText) findViewById(R.id.editText_password);
        editText_dateOfBirth = (EditText) findViewById(R.id.editText_dateOfBirth);
        editText_idNumber = (EditText) findViewById(R.id.editText_idNumber);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        button = (Button) findViewById(R.id.button);

    }
}
