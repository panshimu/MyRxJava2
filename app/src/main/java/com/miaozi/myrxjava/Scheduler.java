package com.miaozi.myrxjava;

import android.os.Handler;
import android.os.Looper;
/**
 * created by panshimu
 * on 2019/11/15
 */
public abstract class Scheduler {
    static Scheduler MAIN_THREAD;
    static Scheduler IO;
    static {
        IO = new IOScheduler();
        MAIN_THREAD = new MainScheduler(new Handler(Looper.getMainLooper()));
    }
    public static Scheduler io(){
        return IO;
    }
    public static Scheduler mainThread(){
        return MAIN_THREAD;
    }
    public abstract void scheduleDirect(Runnable runnable);
}
