package com.miaozi.myrxjava;

/**
 * created by panshimu
 * on 2019/11/13
 */
public class ScalarDisposable<T>{
    final Observer<T> observer;
    final T value;

    public ScalarDisposable(Observer<T> observer, T value) {
        this.observer = observer;
        this.value = value;
    }
    public void run() {
        try {
            observer.onNext(value);
            observer.onComplete();
        }catch (Exception e){
            observer.onError(e);
        }
    }
}
