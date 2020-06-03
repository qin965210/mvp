package com.example.mvpshiyong.service.view;

import com.example.mvpshiyong.service.entity.Receptionbean;

public interface ReceptionView extends View {
    //成功
    void onSuccess(Receptionbean mreceptionbean);
    //失败
    void onError(String result);
}
