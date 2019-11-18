package com.miaozi.myrxjava;


import androidx.annotation.NonNull;

/**
 * created by panshimu
 * on 2019/11/13
 */
public interface ObservableSource<T> {
    void subscribe(@NonNull Observer<T> observer);
}
