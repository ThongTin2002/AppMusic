package com.example.appmusic.Service;

import com.example.appmusic.Model.ChuDeVaTheLoai;
import com.example.appmusic.Model.Example;
import com.example.appmusic.Model.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Example>> GetDataBanner();

    @GET("playlistforcurren.php")
    Call<List<Playlist>> GetplaylistCurrentDay();
    @GET("chudevatheloaitrongngay.php")
    Call<ChuDeVaTheLoai> GetCategoryMusic();
}
