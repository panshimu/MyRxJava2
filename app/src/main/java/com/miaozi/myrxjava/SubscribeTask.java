package com.miaozi.myrxjava;

import android.util.Log;

/**
 * created by panshimu
 * on 2019/11/18
 */
public class SubscribeTask<T> implements Runnable {
    Observer<T> observer;
    final Observable<T> source;

    public SubscribeTask(Observable<T> source, Observer<T> observer) {
        this.source = source;
        this.observer = observer;
    }
    @Override
    public void run() {
        Log.e("TAG", "SubscribeTask" + " 切换到子线程-->"+ source.toString());
        source.subscribe(observer);
    }
}
