import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button_record, button_share;
    String myResult;
    Intent shareIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        textView = (TextView)findViewById(R.id.textView);
        button_record = (Button)findViewById(R.id.button_record);
        button_share = (Button)findViewById(R.id.button_share);
        //

        button_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSpeech(button_record);

            }
        });

        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String recorded_text = textView.getText().toString();

                //share as a text
                shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/pain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,recorded_text);
                startActivity(Intent.createChooser(shareIntent, "Share Via"));


            }
        });

    }

    public void getSpeech(View view){

        //check internet connection
        //google recognizer run in online mode unless download speech plugin pack.
        // 'ACCESS_NETWORK_STATE' needed in manifest to check connection
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            //get speech if there is internet connection
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

            if(intent.resolveActivity(getPackageManager()) != null){
                startActivityForResult(intent,10);
            }else{
                Toast.makeText(this, "This feature is not supported on your device!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "İnternet Bağlantısı Gereklidir!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK && data !=null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textView.setText(result.get(0));
                    myResult = result.get(0);
                }
                break;
        }
    }


    }
