package com.example.keremoflu.anketlisteleme;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ViewPagerExample extends AppCompatActivity {

    private ViewPager viewPager_surveys;
    private ViewPager viewpager;
    private CircleIndicator circleIndicator;

    int count = 0;
    FragmentWebServices fragmentWebServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anket_list);
		
        //
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        circleIndicator = (CircleIndicator) findViewById(R.id.circleIndicator);
        //

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentHeaderAdapter(getSupportFragmentManager());
        viewpager.setAdapter(fragmentPagerAdapter);
        circleIndicator.setViewPager(viewpager);
        set_header_timer(viewpager, 8000, 8000);
    }



	//auto swipe view pager with 3 seconds delay and period
    public void set_header_timer(final ViewPager viewpager, int delay, int period){
        Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        count = viewpager.getCurrentItem()+1;
                        if(count == 3){
                            count=0;
                        }
                        viewpager.setCurrentItem(count);
                    }
                });
            }
        }, delay, period);
    }

}
