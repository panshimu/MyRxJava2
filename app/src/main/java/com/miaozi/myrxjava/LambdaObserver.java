package com.miaozi.myrxjava;
import androidx.annotation.NonNull;
/**
 * created by panshimu
 * on 2019/11/13
 */
public class LambdaObserver<T> implements Observer<T> {
    private Consumer<T> onNext;
    public LambdaObserver(Consumer<T> onNext) {
        this.onNext = onNext;
    }

    @Override
    public void onSubscribe() {
    }

    @Override
    public void onNext(@NonNull T t) {
        try {
            this.onNext.accept(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
