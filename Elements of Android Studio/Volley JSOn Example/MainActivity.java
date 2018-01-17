package com.example.kerem.jsonparse5;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    Activity mActivity;
    Context mContext;
    private String myUrl = "http://www.keremoflu.com/ogrenciler.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);

        mContext = getApplicationContext();
        mActivity = MainActivity.this;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //avoiding to display same json values in textview when clicked more than one time
                textView.setText("");

                RequestQueue requestQueue = Volley.newRequestQueue(mContext);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        myUrl,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    //Json Parsing
                                    JSONArray jsonArray = response.getJSONArray("ogrenciler");

                                    for(int i=0; i<jsonArray.length(); i++){
                                        JSONObject students = jsonArray.getJSONObject(i);

                                        //get values from json
                                        int id = students.getInt("ogrenciNo");
                                        String name = students.getString("ogrenciAdi");
                                        String surname = students.getString("ogrenciSoyadi");
                                        String department = students.getString("bolumAdi");

                                        //display values in textview
                                        textView.append(
                                                "ID: "+id+"\n"+
                                                "Name: "+name+"\n"+
                                                "Surname: "+surname+"\n"+
                                                "Department: "+department+"\n\n");
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(mActivity, "error", Toast.LENGTH_SHORT).show();

                    }
                }
                );
                    requestQueue.add(jsonObjectRequest);
            }
        });


    }
}
