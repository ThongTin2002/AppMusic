package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;

import java.util.ArrayList;

public class PlayNhacActivity extends AppCompatActivity {

    Toolbar toolbarplaynhac;
    TextView txtTimesong,txtTotaltimesong;
    SeekBar sktime;
    ImageButton imgplay,imgrepeat,imgnext,imgpre,imgrandom;
    ViewPager2 viewPagerplaynhac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        init();
        Intent intent = getIntent();
        if (intent.hasExtra("cakhuc")) {
            Baihat baihat = intent.getParcelableExtra("cakhuc");
            Toast.makeText(this, baihat.getTenBaiHat(), Toast.LENGTH_SHORT).show();
        }
        if (intent.hasExtra("cacbaihat")) {
            ArrayList<Baihat> mangbaihat = intent.getParcelableArrayListExtra("cacbaihat");
            for (int i = 0; i < mangbaihat.size(); i++) {
                Log.d("BBB", mangbaihat.get(i).getTenBaiHat());
            }
        }
    }
    private void init(){
        toolbarplaynhac=findViewById(R.id.toolbarplaynhac);
        txtTimesong=findViewById(R.id.textviewtimesong);
        txtTotaltimesong=findViewById(R.id.textviewtotaltimesong);
        sktime=findViewById(R.id.seekbarsong);
        imgplay=findViewById(R.id.imagebuttonplay);
        imgrepeat=findViewById(R.id.imagebuttonrepeat);
        imgnext=findViewById(R.id.imagebuttonnext);
        imgpre=findViewById(R.id.imagebuttonpre);
        imgrandom=findViewById(R.id.imagebuttonsuffle);
        viewPagerplaynhac=findViewById(R.id.viewpagerplaynhac);
        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);
    }
}