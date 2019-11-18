package com.miaozi.myrxjava;

import android.os.Handler;
import android.os.Message;

/**
 * created by panshimu
 * on 2019/11/18
 */
public class MainScheduler extends Scheduler {
    private Handler handler;
    public MainScheduler(Handler handler) {
        this.handler = handler;
    }
    @Override
    public void scheduleDirect(Runnable runnable) {
        Message obtain = Message.obtain(handler, runnable);
        handler.sendMessage(obtain);
    }
}
