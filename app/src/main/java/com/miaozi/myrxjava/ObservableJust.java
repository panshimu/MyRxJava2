package com.miaozi.myrxjava;

import android.util.Log;

/**
 * created by panshimu
 * on 2019/11/13
 */
public final class ObservableJust<T> extends Observable<T>{
    private final T value;
    public ObservableJust(final T value) {
        this.value = value;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        Log.e("TAG","ObservableJust" + " observer="+observer.toString());
        ScalarDisposable<T> sd = new ScalarDisposable<T>(observer, value);
        observer.onSubscribe();
        sd.run();
    }
}
