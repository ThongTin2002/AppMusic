package com.example.appmusic.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPagerPlaylistnhac extends FragmentStateAdapter {
    public final ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    public ViewPagerPlaylistnhac(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentArrayList.size();
    }
    public void AddFragment(Fragment fragment){
        fragmentArrayList.add(fragment);
    }
}
