package com.example.appmusic.Service;

import com.example.appmusic.Model.Album;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.Model.ChuDeVaTheLoai;
import com.example.appmusic.Model.Example;
import com.example.appmusic.Model.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Example>> GetDataBanner();

    @GET("playlistforcurren.php")
    Call<List<Playlist>> GetplaylistCurrentDay();
    @GET("chudevatheloaitrongngay.php")
    Call<ChuDeVaTheLoai> GetCategoryMusic();
    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();
    @GET("baihatduocthich.php")
    Call<List<Baihat>> GetBaiHatHot();
    //tao phuong thuc tuong tac ben server gui du lieu len de lay phan du lieu quang cao ve
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    //gui du lieu len server qua phuong thuc @Field
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);
    @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhsachcacplaylist();
}
