package com.miaozi.myrxjava;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * created by panshimu
 * on 2019/11/13
 */
public abstract class Observable<T> implements ObservableSource<T>{
    public static <T> Observable<T> just(T item) {
        return RxJavaPlugins.onAssembly(new ObservableJust<T>(item));
    }
    @Override
    public void subscribe(@NonNull Observer<T> observer) {
        subscribeActual(observer);
    }
    //发送开始
    public final void subscribe(Consumer<T> onNext) {
        subscribe(onNext,null,null);
    }
    private void subscribe(Consumer<T> onNext, Object o, Object o1) {
        subscribe(new LambdaObserver<T>(onNext));
    }
    public <U> Observable<U> map(Function<T,U> function){
        return RxJavaPlugins.onAssembly(new ObservableMap<T,U>(this, function));
    }
    public final Observable<T> subscribeOn(Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new ObservableSubscribeOn<T>(this, scheduler));
    }
    public final Observable<T> observeOn(Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new ObservableObserveOn<T>(this, scheduler));
    }
    protected abstract void subscribeActual(Observer<T> observer);

}
