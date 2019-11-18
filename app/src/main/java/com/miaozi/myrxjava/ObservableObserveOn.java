package com.miaozi.myrxjava;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * created by panshimu
 * on 2019/11/15
 */
class ObservableObserveOn<T> extends Observable<T> {
    Observable<T> source;
    Scheduler scheduler;
    public ObservableObserveOn(Observable<T> source, Scheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        Log.e("TAG","ObservableObserveOn"+ " observer="+observer.toString());
        source.subscribe(new ObserveOnObserver(observer));
    }

    private class ObserveOnObserver implements Observer<T>, Runnable {
        private T item;
        final Observer<T> observer;
        public ObserveOnObserver(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onSubscribe() {
            observer.onSubscribe();
        }

        @Override
        public void onNext(@NonNull T t) {
            item = t;
            scheduler.scheduleDirect(this);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            observer.onError(e);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }

        @Override
        public void run() {
            observer.onNext(item);
        }
    }
}
