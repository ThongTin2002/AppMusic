package com.example.appmusic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appmusic.Adapter.MainViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();

    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this);
        viewPager.setAdapter(mainViewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setIcon(R.drawable.icontrangchu);
                    tab.setText("Trang chu");
                    break;
                case 1:
                    tab.setIcon(R.drawable.iconsearch);
                    tab.setText("Tim kiem");
                    break;
            }
        }).attach();
    }

    private void anhxa() {
        tabLayout=findViewById(R.id.myTabLayout);
        viewPager=findViewById(R.id.myViewpager);
    }
}