package com.miaozi.myrxjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable
                .just("miaozi")// 返回 ObservableJust
            .map(new Function<String, String>() {
                @Override
                public String apply(@NonNull String s) throws Exception {
                    //可进行耗时操作
                    return s;
                }
            })// 返回 ObservableMap
            .subscribeOn(Scheduler.io())// 返回 ObservableSubscribeOn
            .observeOn(Scheduler.mainThread())// ObservableObserveOn
            .subscribe(new Consumer<String>() {//开始执行
                @Override
                public void accept(String s) throws Exception {
                    Log.e("TAG",s);
                }
            });
    }
}
