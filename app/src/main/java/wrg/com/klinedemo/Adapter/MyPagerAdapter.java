package wrg.com.klinedemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 翁 on 2017/3/1.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;
    private List<String> mTitle;



    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments=new ArrayList<>();
        mTitle=new ArrayList<>();
    }
    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mTitle.add(title);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
