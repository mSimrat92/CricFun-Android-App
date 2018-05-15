package com.example.sachinsharma.cricfun;

/**
 * Created by sachinsharma on 1/1/18.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Calendar;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter{

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Yesterday", "Today", "Tomorrow" };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }
    @Override
    public Fragment getItem(int position) {
        Calendar cal=Calendar.getInstance();
        switch (position){
            case 0:
                int demo=cal.get(Calendar.DAY_OF_MONTH);
                if(demo==1){
                    cal.set(Calendar.DAY_OF_MONTH,31);
                    return new PageFragment().newInstance(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                }
                return new PageFragment().newInstance(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)-1));
            case 1:
                return new PageFragment().newInstance(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
            case 2:
                demo=cal.get(Calendar.DAY_OF_MONTH);
                if(demo==31){
                    cal.set(Calendar.DAY_OF_MONTH,1);
                    return new PageFragment().newInstance(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                }
                else{
                    return new PageFragment().newInstance(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)+1));
                }


        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
