package dailyquotes.kerem.openweatherapi;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public TextView textView_parse;
    private Button button_parse;
    public double temp;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        textView_parse = (TextView)findViewById(R.id.textView_parse);
        button_parse = (Button) findViewById(R.id.button_parse);
        //

        button_parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new JSONParsing().execute("https://newsapi.org/v2/top-headlines?sources=abc-news&apiKey=b1ed0a1fd9ca444fa9a9dd52b754fc6b");
                
            }
        });
    }

    private class JSONParsing extends AsyncTask<String, String, String>{


        @Override
        protected String doInBackground(String... strings) {

            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;

            try{
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.connect();

                InputStream stream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";

                while((line = bufferedReader.readLine()) != null){
                    stringBuffer.append(line);
                }

                String finalJson = stringBuffer.toString();

                StringBuffer finalBuffer = new StringBuffer();
                JSONObject jsonObject = new JSONObject(finalJson);
                JSONArray parentArray = jsonObject.getJSONArray("articles");

                for(int i=0; i<parentArray.length(); i++){

                    JSONObject parentObject = parentArray.getJSONObject(i);
                    String title = parentObject.getString("title");
                    finalBuffer.append(title+"\n\n");


                }

                /* tek çekim
                JSONObject parentObject = parentArray.getJSONObject(0);
                String title = parentObject.getString("title");
                */


                return finalBuffer.toString();

            }catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            textView_parse.setText(s);

        }
    }
}
