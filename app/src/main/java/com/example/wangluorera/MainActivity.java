package com.example.wangluorera;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.text);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建Retrofit请求参数
                Retrofit build = new Retrofit.Builder()
                        .baseUrl("http://api.tianapi.com")
                        //解析器
                        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                //创建
                GetRequest_Interface getRequest_interface = build.create(GetRequest_Interface.class);
                Observable<Receptionbean> getcall = getRequest_interface.getcall("8ec324bf03d34f7706fb4c35a4355d7e");
                getcall.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Receptionbean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace(); //请求过程中发生错误
                            }

                            @Override
                            public void onNext(Receptionbean receptionbean) {
                                List<Receptionbean.NewslistBean> newslist = receptionbean.getNewslist();
                                String title = newslist.get(0).getTitle();
                                textView1.setText(title+"");
                            }
                        });



                //调用接口的方法
                //Call<Receptionbean> call = getRequest_interface.getcall("8ec324bf03d34f7706fb4c35a4355d7e");
                //参数返回
               /* call.enqueue(new Callback<Receptionbean>() {
                    @Override
                    public void onResponse(Call<Receptionbean> call, Response<Receptionbean> response) {
                        Receptionbean body = response.body();
                        int code = body.getCode();
                        textView1.setText(code+"");
                    }

                    @Override
                    public void onFailure(Call<Receptionbean> call, Throwable t) {
                        System.out.println("连接失败");
                    }
                });*/
            }
        });
    }
}
