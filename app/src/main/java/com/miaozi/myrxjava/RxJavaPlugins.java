package com.miaozi.myrxjava;

import androidx.annotation.NonNull;

/**
 * created by panshimu
 * on 2019/11/13
 */
public final class RxJavaPlugins {
    public static <T> Observable<T> onAssembly(@NonNull Observable<T> source) {
        return source;
    }
}
