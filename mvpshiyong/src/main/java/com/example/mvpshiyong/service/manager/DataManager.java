package com.example.mvpshiyong.service.manager;

import android.content.Context;

import com.example.mvpshiyong.service.RetrofitHelper;
import com.example.mvpshiyong.service.RetrofitService;
import com.example.mvpshiyong.service.entity.Receptionbean;

import rx.Observable;

public class DataManager {
    private RetrofitService mRetrofitService;
    //网络请求前部分
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    //传入参数 调用的方法
    public Observable<Receptionbean> getSearchBooks(String key){
        return mRetrofitService.getzhushuju(key);
    }

}
