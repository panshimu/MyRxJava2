package com.miaozi.myrxjava;

import android.util.Log;


/**
 * created by panshimu
 * on 2019/11/15
 */
public class ObservableSubscribeOn<T> extends Observable<T> {
    final Observable<T> source;
    final Scheduler scheduler;
    public ObservableSubscribeOn(Observable<T> source, Scheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        Log.e("TAG","ObservableSubscribeOn" + " observer="+observer.toString());
        scheduler.scheduleDirect(new SubscribeTask(source,observer));
    }
}
