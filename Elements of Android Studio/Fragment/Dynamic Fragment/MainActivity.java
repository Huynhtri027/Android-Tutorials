package com.example.kerem.dynamicfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
    }


    public void buttonClick(View view){

        switch (view.getId()){
            case R.id.button_fragment1:
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                DynamicFragment_1 dynamicFragment_1 = new DynamicFragment_1();
                transaction.replace(R.id.containerLayout,dynamicFragment_1,"DynamicFragment1"); //containerLayout is id of layout to show fragments
                transaction.addToBackStack(null); //enabled to use back button pressed to show previous fragment
                transaction.commit();
                break;

            case R.id.button_fragment2:
                FragmentTransaction transaction2 = fragmentManager.beginTransaction();
                DynamicFragment_2 dynamicFragment_2 = new DynamicFragment_2();
                transaction2.replace(R.id.containerLayout,dynamicFragment_2,"DynamicFragment2");
                transaction2.addToBackStack(null);
                transaction2.commit();
                break;

        }

    }
}
