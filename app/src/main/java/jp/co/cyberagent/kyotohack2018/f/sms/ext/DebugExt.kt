package jp.co.cyberagent.kyotohack2018.f.sms.ext

import android.content.Context
import android.util.Log
import android.widget.Toast

fun <T : Any> T.println() = this.apply { Log.d("LOG", toString()) }

fun <T : Context> T.shoToast(text : String, value : Int) = Toast.makeText(this, text, value).show()