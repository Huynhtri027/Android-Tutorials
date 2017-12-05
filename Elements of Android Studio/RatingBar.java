import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    //We can decide how much starts we will add in XML with "numStars"

    RatingBar ratingBar;
    TextView textView_choosed, textView_howMany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        textView_choosed = (TextView)findViewById(R.id.textView_choosed);
        textView_howMany = (TextView)findViewById(R.id.textView_howMany);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView_howMany.setText(""+v);
            }
        });

    }
}
