package forwhatsapp.speechtotext.oop_series_getset;

import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import forwhatsapp.speechtotext.oop_series_getset.Adapter.Adapter_Movie;
import forwhatsapp.speechtotext.oop_series_getset.Model.Model_Movie;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private Adapter_Movie movieAdapter;
    private ArrayList<Model_Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        movieArrayList = new ArrayList<>();
        movieArrayList.add(new Model_Movie("Fight Club",1999));
        movieArrayList.add(new Model_Movie("Fight Club",1999));
        movieArrayList.add(new Model_Movie("The Shawshank Redemption",1994));
        movieArrayList.add(new Model_Movie("The Shawshank Redemption",1994));
        movieArrayList.add(new Model_Movie("The Shawshank Redemption",1994));
        movieArrayList.add(new Model_Movie("Fight Club",1999));
        movieArrayList.add(new Model_Movie("Fight Club",1999));

        movieAdapter = new Adapter_Movie(getApplicationContext(),movieArrayList);
        gridView.setAdapter(movieAdapter);


    }
}
