package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appmusic.Model.Example;
import com.example.appmusic.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DanhsachbaihatActivity extends AppCompatActivity {
    Example quangcao;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        DataIntent();
        anhxa();
    }

    private void anhxa() {
        coordinatorLayout=findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout=findViewById(R.id.collapsingtoolbar);
        toolbar=findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachbaihat=findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton=findViewById(R.id.floatingactionbutton);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("banner")) {
                quangcao = (Example) intent.getSerializableExtra("banner");
                Toast.makeText(this, quangcao.getTenBaiHat(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}