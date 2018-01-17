package com.example.kerem.jsonparse4.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kerem.jsonparse4.Model.Ogrenci;
import com.example.kerem.jsonparse4.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Kerem on 17.01.2018.
 */

public class GridViewAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    ArrayList<Ogrenci> ogrenciler;
    View myView;

    ImageView imageView;
    TextView textView_ad, textView_soyad, textView_bolum;

    public GridViewAdapter(Activity activity, ArrayList<Ogrenci> ogrenciler){
        this.ogrenciler=ogrenciler;
        this.context=activity;
    }

    @Override
    public int getCount() {
        return ogrenciler.size();
    }

    @Override
    public Object getItem(int i) {
        return ogrenciler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        context = viewGroup.getContext();
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view==null){
            myView = new View(context);
            view = layoutInflater.inflate(R.layout.custom_grid_gorunumu,null);
            imageView = (ImageView)view.findViewById(R.id.imageView);
            textView_ad = (TextView)view.findViewById(R.id.textView_ad);
            textView_soyad = (TextView)view.findViewById(R.id.textView_soyad);
            textView_bolum= (TextView)view.findViewById(R.id.textView_bolum);

            textView_ad.setText(ogrenciler.get(i).getOgrenciAdi());
            textView_soyad.setText(ogrenciler.get(i).getOgrenciSoyadi());
            textView_bolum.setText(ogrenciler.get(i).getBolumAdi());
            Picasso.with(context)
                            .load(ogrenciler.get(i)
                            .getOgrenciResim())
                            .into(imageView);
        }


        return view;
    }
}
