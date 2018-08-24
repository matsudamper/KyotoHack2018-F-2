package jp.co.cyberagent.kyotohack2018.f.sms.core

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.io.Serializable
import kotlin.reflect.KProperty

fun <T> Activity.bundle(name: String? = null, default: T? = null): KotBundle<T> = KotBundle(name, default) { intent.extras }
fun <T> Fragment.bundle(name: String? = null, default: T? = null): KotBundle<T> = KotBundle(name, default) { arguments }
fun <T> bundle(name: String? = null, default: T? = null, getBundle: () -> Bundle?): KotBundle<T> = KotBundle(name, default) { getBundle() }

class KotBundle<T>(
        private val name: String?,
        private val defaultValue: T? = null,
        val getBundle: () -> Bundle?
) : Serializable {

    private object UNINITIALIZED_VALUE

    private var value_: Any? = UNINITIALIZED_VALUE

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        value_ = value
    }

    @Suppress("UNCHECKED_CAST")
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value_ != UNINITIALIZED_VALUE) return value_ as T

        val bundle = getBundle()
        val key = name ?: property.name

        value_ = bundle?.takeIf { it.containsKey(key) }?.get(key) ?: defaultValue

        return value_ as T
    }
}
