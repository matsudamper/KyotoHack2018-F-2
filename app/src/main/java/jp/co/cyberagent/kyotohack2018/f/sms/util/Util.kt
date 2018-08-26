package jp.co.cyberagent.kyotohack2018.f.sms.util

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

val logPrintObserver = object : LifecycleObserver {

    val TAG = "LOG"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() = Log.d(TAG, "onCreate")

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() = Log.d(TAG, "onStart")

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() = Log.d(TAG, "onResume")

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() = Log.d(TAG, "onPause")

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() = Log.d(TAG, "onStop")

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() = Log.d(TAG, "onDestroy")
}