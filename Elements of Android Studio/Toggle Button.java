

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    TextView textView_value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        textView_value = (TextView) findViewById(R.id.textView_value);


        textView_value.setText("OFF");
        toggleButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(toggleButton.isChecked()){
                   textView_value.setText("ON");
               }else{
                   textView_value.setText("OFF");
               }
           }
       });



    }
}
