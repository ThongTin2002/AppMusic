package com.example.appmusic.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appmusic.Fragment.Fragment_Tim_Kiem;
import com.example.appmusic.Fragment.Fragment_Trang_Chu;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> arrayfragment =new ArrayList<>();
    private ArrayList<String> arraytitle =new ArrayList<>();

    public MainViewPagerAdapter(@NonNull FragmentActivity fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new Fragment_Tim_Kiem();

            default:
                return new Fragment_Trang_Chu();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

//    public void addFrament(Fragment fragment, String title){
//        arrayfragment.add(fragment);
//        arraytitle.add(title);
//    }

}
