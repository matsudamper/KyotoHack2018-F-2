package jp.co.cyberagent.kyotohack2018.f.sms.flux

interface Dispatcher {

     fun <T> dispatch(action: Action<T>) {
        throw IllegalStateException()
    }
}