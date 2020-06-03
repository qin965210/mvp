package com.example.mvpshiyong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpshiyong.service.entity.Receptionbean;
import com.example.mvpshiyong.service.presenter.ReceptionPresenter;
import com.example.mvpshiyong.service.view.ReceptionView;

public class MainActivity extends AppCompatActivity {

    private TextView text01;
    private Button button01;
    //调用P层传入上下文
    private ReceptionPresenter receptionPresenter=new ReceptionPresenter(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = findViewById(R.id.button01);
        text01 = findViewById(R.id.text01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receptionPresenter.getSearchBooks("8ec324bf03d34f7706fb4c35a4355d7e");
            }
        });
        receptionPresenter.onCreate();
        receptionPresenter.attachView(mreception);
    }
    private ReceptionView mreception=new ReceptionView() {
        @Override
        public void onSuccess(Receptionbean mreceptionbean) {
            String answerA = mreceptionbean.getNewslist().get(0).getAnswerA();
            text01.setText(answerA);
        }

        @Override
        public void onError(String result) {
            Toast.makeText(MainActivity.this,result+"",Toast.LENGTH_SHORT).show();
        }
    };
    //解耦
    @Override
    protected void onDestroy() {
        super.onDestroy();
        receptionPresenter.onStop();
    }
}
