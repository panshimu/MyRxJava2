package com.miaozi.myrxjava;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * created by panshimu
 * on 2019/11/13
 */
public class ObservableMap<T, U> extends Observable<U>{
    final Observable<T> source;
    final Function<T,U> function;
    public ObservableMap(Observable<T> source, Function<T,U> function) {
        this.function = function;
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        Log.e("TAG","ObservableMap"+" observer="+observer.toString());
        //静态代理
        source.subscribe(new MapObserver<T>(observer,function));
    }

    private final class MapObserver<T> implements Observer<T> {
        final Function<T,U> function;
        final Observer<U> observer;
        public MapObserver(Observer<U> observer, Function<T,U> function) {
            this.function = function;
            this.observer = observer;
        }
        @Override
        public void onSubscribe() {
            observer.onSubscribe();
        }
        @Override
        public void onNext(@NonNull T t) {
            try {
                U apply = function.apply(t);
                observer.onNext(apply);
            }catch (Exception e){
                observer.onError(e);
            }
        }
        @Override
        public void onError(@NonNull Throwable e) {
            observer.onError(e);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }
}
