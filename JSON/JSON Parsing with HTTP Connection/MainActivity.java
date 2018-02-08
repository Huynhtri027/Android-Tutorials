package dailyquotes.kerem.jsonseries_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Button button_fetch;
    public static TextView textView_fetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        button_fetch = (Button)findViewById(R.id.button_fetch);
        textView_fetch = (TextView)findViewById(R.id.textView_fetch);
        //

        button_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchData process = new fetchData();
                process.execute();

            }
        });
    }
}
