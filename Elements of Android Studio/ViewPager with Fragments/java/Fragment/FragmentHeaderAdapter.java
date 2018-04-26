package com.example.keremoflu.anketlisteleme.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Kerem Oflu on 24.04.2018.
 */

public class FragmentHeaderAdapter extends FragmentPagerAdapter{

    Page1Fragment page1Fragment;
    Page2Fragment page2Fragment;
    Page3Fragment page3Fragment;

    public FragmentHeaderAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Page1Fragment();

            case 1:
                return new Page2Fragment();

            case 2:
                return new Page3Fragment();

            default:
                break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
