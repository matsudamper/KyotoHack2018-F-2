package jp.co.cyberagent.kyotohack2018.f.sms.ext

import androidx.lifecycle.toLiveData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.FlowableProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

fun <T> FlowableProcessor<T>.toFlowable(): Flowable<T> = this
fun <T> Flowable<T>.toLastFlowable(): Flowable<T> = this.onBackpressureLatest()

fun <T> Flowable<out Action<T>>.toMapFlowable(): Flowable<T> = this
        .map { it.data }
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<out Action<T>>.toMapLiveData() = this.toMapFlowable().toLiveData()