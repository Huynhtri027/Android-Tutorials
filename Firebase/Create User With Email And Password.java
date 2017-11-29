package com.example.kerem.firebaseapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/* IMPORTANT NOTES
    Email must be valid like using @ sign
    Password must be at least 6 values

    minSdk: 20
    add dependencies: compile 'com.google.firebase:firebase-auth:10.0.1'
    internet permission might be needed
 */
    public class MainActivity extends AppCompatActivity {

    EditText editText_email, editText_password;
    Button button_signUp;

        private FirebaseAuth firebaseAuth;
        private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        editText_email = (EditText)findViewById(R.id.editText_email);
        editText_password = (EditText)findViewById(R.id.editText_password);
        button_signUp = (Button) findViewById(R.id.button_signUp);


        button_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    userRegister();
            }
        });

    }
        public void userRegister(){

            String email = editText_email.getText().toString();
            String password = editText_password.getText().toString();

            progressDialog.setMessage("Registering User");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(email,password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else{
                                Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
        }
}
