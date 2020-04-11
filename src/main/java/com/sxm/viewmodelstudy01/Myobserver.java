package com.sxm.viewmodelstudy01;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;


public class Myobserver implements LifecycleObserver {
    private final String TAG = "Myobserver";
    private Lifecycle lifecycle;

    Myobserver(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void myStrat() {
        Log.d(TAG, "myStrat: ");
        Log.d(TAG, "myStrat: " + lifecycle.getCurrentState());

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void myStop() {
        Log.d(TAG, "myStop: ");
    }
}
