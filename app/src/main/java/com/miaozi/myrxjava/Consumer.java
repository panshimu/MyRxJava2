package com.miaozi.myrxjava;

/**
 * created by panshimu
 * on 2019/11/13
 */
public interface Consumer<T> {
    void accept(T t) throws Exception;
}
