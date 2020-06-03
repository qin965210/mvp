package com.example.mvpshiyong.service.presenter;

import android.content.Intent;

import com.example.mvpshiyong.service.view.View;

public interface Presenter {
    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(View view);

    void attachIncomingIntent(Intent intent);

}
