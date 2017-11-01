package com.example.kerem.veritabaniornekuygulama1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_nameSurname, editText_email, editText_adress;
    Button button_list, button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_nameSurname = (EditText) findViewById(R.id.editText_nameSurname);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_adress = (EditText) findViewById(R.id.editText_adress);

    }

    public void clickedButton(View view){
        switch (view.getId()){

            case R.id.button_save:

                String nameSurname=editText_nameSurname.getText().toString();
                String email=editText_email.getText().toString();
                String adress=editText_adress.getText().toString();

                Student student = new Student(nameSurname, email, adress);

                Database db = new Database(getApplicationContext());
                long id = db.newRegister(student);

                if(id==-1){
                    Toast.makeText(this, "Hata", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                    editText_nameSurname.setText("");
                    editText_email.setText("");
                    editText_adress.setText("");
                }

                break;

            case R.id.button_list:
                Intent intent = new Intent(getApplicationContext(),Listele.class);
                startActivity(intent);


                break;

        }
    }
}
