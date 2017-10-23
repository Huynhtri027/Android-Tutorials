package com.example.kerem.loginscreen;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IntroActivity extends AppCompatActivity {
    Typeface type;
    EditText editText_login_username,editText_login_password;
    TextView textView_welcome, textView_subHeader,textView_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        textView_register = (TextView) findViewById(R.id.textView_register);

        textView_welcome = (TextView) findViewById(R.id.textView_welcome);
        textView_welcome.setAlpha(0.9f);

        textView_subHeader = (TextView) findViewById(R.id.textView_subHeader);
        textView_subHeader.setAlpha(0.7f);

        editText_login_username = (EditText) findViewById(R.id.editText_login_username);
        editText_login_password = (EditText) findViewById(R.id.editText_login_password);

        editText_login_username.setAlpha(0.3f);
        editText_login_password.setAlpha(0.4f);


        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_login_to_register = new Intent(IntroActivity.this,MainActivity.class);
                startActivity(intent_login_to_register);

            }
        });


    }
}
