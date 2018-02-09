package dailyquotes.kerem.jsonseries_4;
//tutorial_credits: https://www.youtube.com/watch?v=bFMvE-zSjGE&list=PLgjt1h_kabFebUn1anGYZ6_Tfkw64Ww12&index=15

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private Button button_parse;
    private TextView textView_parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        button_parse = (Button)findViewById(R.id.button_parse);
        textView_parse = (TextView)findViewById(R.id.textView_parse);


        button_parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               new JSONTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoList.txt");


            }
        });

    }


    private class JSONTask extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... urls) {

            HttpURLConnection connection = null;
            BufferedReader bufferedReader = null;

            try{
                URL url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";

                while((line = bufferedReader.readLine()) != null){
                    stringBuffer.append(line);
                }

                String finalJson = stringBuffer.toString();


                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("movies");

                StringBuffer finalBuffer = new StringBuffer();

                for(int i=0; i<parentArray.length(); i++){
                    JSONObject finalObject = parentArray.getJSONObject(i);

                    String movieName = finalObject.getString("movie");
                    int year = finalObject.getInt("year");
                    finalBuffer.append(movieName+ " - "+year+"\n");
                }

                return finalBuffer.toString();




            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null){
                    connection.disconnect();
                }
                try {
                    if(bufferedReader != null){
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textView_parse.setText(result);


        }
    }



}
