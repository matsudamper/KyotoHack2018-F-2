package jp.co.cyberagent.kyotohack2018.f.sms.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, block: ((T) -> Unit)) = this.apply {
    this.observe(owner, Observer {
        it ?: return@Observer
        block(it)
    })
}
