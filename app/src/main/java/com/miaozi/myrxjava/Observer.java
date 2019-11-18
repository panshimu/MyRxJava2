package com.miaozi.myrxjava;

import androidx.annotation.NonNull;

/**
 * created by panshimu
 * on 2019/11/13
 */
public interface Observer<T> {
    void onSubscribe();
    void onNext(@NonNull T t);
    void onError(@NonNull Throwable e);
    void onComplete();
}
