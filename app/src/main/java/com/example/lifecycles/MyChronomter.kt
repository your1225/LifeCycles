package com.example.lifecycles

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyChronomter(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs) , LifecycleObserver {

    companion object {
        var elapsedTime: Long = 0
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pauseMeter() {
        //elapsedRealtime 指手机从上次启动到现在所经过的时间的毫秒数
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeMeter() {
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()
    }
}