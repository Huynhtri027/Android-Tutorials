package com.example.kerem.loginscreen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.kerem.loginscreen.R.drawable.oval;

public class MainActivity extends AppCompatActivity {

    ImageView imageview_logo;

    TextView textView_error;

    EditText editText_username,
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

        /// - DECLERATIONS - ///
        //imageview_logo = (ImageView) findViewById(R.id.imageview_logo);

        editText_username = (EditText) findViewById(R.id.editText_username);
        //editText_lastName = (EditText) findViewById(R.id.editText_lastName);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_password = (EditText) findViewById(R.id.editText_password);
        editText_dateOfBirth = (EditText) findViewById(R.id.editText_dateOfBirth);
        //editText_idNumber = (EditText) findViewById(R.id.editText_idNumber);
        checkBox = (CheckBox) findViewById(R.id.checkBox);


        button = (Button) findViewById(R.id.button);

        textView_error = (TextView) findViewById(R.id.textView_error);
        //////////////////////////////////////

        //ADJUSTING OPACITY OF EDIT TEXTS

        editText_username.setAlpha(0.3f);
        editText_email.setAlpha(0.3f);
        editText_password.setAlpha(0.3f);
        editText_dateOfBirth.setAlpha(0.3f);
        checkBox.setAlpha(0.5f);

        textView_error.setText("");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GET TEXTS //
                String username= editText_username.getText().toString();
                String email = editText_email.getText().toString();
                String password = editText_password.getText().toString();
                String dateOfBirth = editText_dateOfBirth.getText().toString();


               if(username.isEmpty() || email.isEmpty() || password.isEmpty() || dateOfBirth.isEmpty()){

                   textView_error.setText("All blanks must be filled");
                   //textView_error_allBlanks.setVisibility(View.VISIBLE);
                   //textview_error_terms.setVisibility(View.INVISIBLE);
                   //Toast.makeText(MainActivity.this, "All blanks must be filled", Toast.LENGTH_SHORT).show();
               }else if(checkBox.isChecked()==false){
                   //Toast.makeText(MainActivity.this, "You must accept terms", Toast.LENGTH_SHORT).show();
                   textView_error.setText("You must accept the terms");
               }
               else{
                   textView_error.setText("");
                   Toast.makeText(MainActivity.this, "Great, You can login now!", Toast.LENGTH_SHORT).show();
                   Intent intent_register_to_login = new Intent(MainActivity.this,IntroActivity.class);
                   startActivity(intent_register_to_login);

               }
            }
        });


    }
}
