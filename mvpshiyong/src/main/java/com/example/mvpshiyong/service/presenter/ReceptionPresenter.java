package com.example.mvpshiyong.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.mvpshiyong.service.entity.Receptionbean;
import com.example.mvpshiyong.service.manager.DataManager;
import com.example.mvpshiyong.service.view.ReceptionView;
import com.example.mvpshiyong.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ReceptionPresenter  implements Presenter {



    private ReceptionView receptionView;
    private Context mContext;
    private DataManager dataManager;
    private CompositeSubscription compositeSubscription;
    private Receptionbean receptionbean1;

    public ReceptionPresenter(Context context)
    {
        mContext=context;
    }

    @Override
    public void onCreate() {
        //调用m层
        dataManager = new DataManager(mContext);
        //RXjava的调用方法
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        //判断RXjava的调用方法是否打开
        if (compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        receptionView = (ReceptionView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {
    }
    public void getSearchBooks(String key)
    {
        compositeSubscription.add(
                dataManager.getSearchBooks(key)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Receptionbean>() {



                            @Override
                            public void onCompleted() {

                                if (receptionbean1!=null)
                                {
                                    receptionView.onSuccess(receptionbean1);
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                                receptionView.onError("数据请求失败");
                            }

                            @Override
                            public void onNext(Receptionbean receptionbean) {
                                receptionbean1 = receptionbean;
                            }
                        })

        );
    }


}
