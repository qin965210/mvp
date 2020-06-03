package com.example.mvpshiyong.service;

import com.example.mvpshiyong.service.entity.Receptionbean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RetrofitService {
    //键值对
    @FormUrlEncoded
    @POST("/txapi/baiketiku/index")
    //key=8ec324bf03d34f7706fb4c35a4355d7e
    Observable<Receptionbean> getzhushuju(@Field("key") String key);
}
