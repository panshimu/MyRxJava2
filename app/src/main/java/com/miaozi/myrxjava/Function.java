package com.miaozi.myrxjava;

import androidx.annotation.NonNull;

/**
 * created by panshimu
 * on 2019/11/13
 */
public interface Function<T,R> {
    R apply(@NonNull T t) throws Exception;
}
