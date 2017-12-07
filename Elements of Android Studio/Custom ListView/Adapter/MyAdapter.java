package com.example.kerem.customlistview.Adapter;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kerem.customlistview.MainActivity;
import com.example.kerem.customlistview.Model.Ulkeler;
import com.example.kerem.customlistview.R;

import java.util.ArrayList;

/**
 * Created by Kerem on 07.12.2017.
 */

public class MyAdapter extends BaseAdapter {
    TextView textView_ad;
    TextView textView_baskent;
    TextView textView_nufus;
    ImageView imageView;
    private ArrayList<Ulkeler> ulkelers;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter (Activity activity, ArrayList<Ulkeler> ulkeler){
        this.context=activity;
        this.ulkelers=ulkeler;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return ulkelers.size();
    }

    @Override
    public Object getItem(int i) {
        return ulkelers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         View myView = layoutInflater.inflate(R.layout.ulkeler_satirgorunumu,null);
         textView_ad = (TextView) myView.findViewById(R.id.textView_ad);
         textView_baskent = (TextView)myView.findViewById(R.id.textView_baskent);
         textView_nufus = (TextView)myView.findViewById(R.id.textView_nufus);
         imageView = (ImageView) myView.findViewById(R.id.imageView);

        textView_ad.setText(ulkelers.get(i).getAd());
        textView_baskent.setText(ulkelers.get(i).getBaskent());
        textView_nufus.setText(""+ulkelers.get(i).getNufus());
        int id = context.getResources().getIdentifier(
                ulkelers.get(i).getResim(),
                "drawable",
                context.getPackageName());
        imageView.setImageResource(id);

        //setOnItemClickListener is in MainActivity
        return myView;
    }
}
