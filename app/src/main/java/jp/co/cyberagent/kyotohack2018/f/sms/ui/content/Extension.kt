package jp.co.cyberagent.kyotohack2018.f.sms.ui.content


fun <T> Any.cast(type: Class<T>) = this as T
fun <T> Any.safeCast(type: Class<T>) = this as? T