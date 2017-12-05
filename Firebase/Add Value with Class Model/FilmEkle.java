import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kerem.firebaseodev.Model.Filmler;
import com.example.kerem.firebaseodev.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FilmEkle extends AppCompatActivity {

    TextView textView_filmEkle;
    EditText editText_filmAdi, editText_filmKategori, editText_filmYonetmen;
    Button button_filmEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_ekle);


        textView_filmEkle = (TextView)findViewById(R.id.textView_filmEkle);
        editText_filmAdi = (EditText)findViewById(R.id.editText_filmAdi);
        editText_filmKategori = (EditText)findViewById(R.id.editText_filmKategori);
        editText_filmYonetmen = (EditText)findViewById(R.id.editText_filmYonetmen);
        button_filmEkle = (Button) findViewById(R.id.button_filmEkle);


        button_filmEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference filmRef = FirebaseDatabase.getInstance().getReference().child("film");
                filmRef.push().setValue(
                        new Filmler(
                                    editText_filmAdi.getText().toString(),
                                    editText_filmKategori.getText().toString(),
                                    editText_filmYonetmen.getText().toString()
                        )
                );
                Toast.makeText(FilmEkle.this, "Film başarıyla eklendi!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }
}
