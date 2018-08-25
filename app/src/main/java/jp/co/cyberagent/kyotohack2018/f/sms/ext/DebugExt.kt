package jp.co.cyberagent.kyotohack2018.f.sms.ext

import android.util.Log

fun <T : Any> T.println() = this.apply { Log.d("LOG", toString()) }