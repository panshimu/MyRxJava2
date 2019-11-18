package com.miaozi.myrxjava;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * created by panshimu
 * on 2019/11/18
 */
public class IOScheduler extends Scheduler {
    private ExecutorService executorService;
    public IOScheduler(){
        executorService = Executors.newScheduledThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
    }
    @Override
    public void scheduleDirect(Runnable runnable) {
        Log.e("TAG","IOScheduler");
        executorService.execute(runnable);
    }
}
