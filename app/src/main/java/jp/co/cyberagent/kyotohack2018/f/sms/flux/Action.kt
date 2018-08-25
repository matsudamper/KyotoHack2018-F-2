package jp.co.cyberagent.kyotohack2018.f.sms.flux

interface Action<out T> {
    val data: T
}