import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kerem.firebaseodev.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView textView_movieList, textView_movieList2;
    Button button_ekle, button_listele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_movieList = (TextView)findViewById(R.id.textView_movieList);
        textView_movieList2 = (TextView)findViewById(R.id.textView_movieList2);

        button_ekle = (Button)findViewById(R.id.button_ekle);
        button_listele = (Button)findViewById(R.id.button_listele);

        button_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FilmEkle.class));
            }
        });

        button_listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FilmListele.class));
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference filmRef = database.getReference("filmler");


    }
}
