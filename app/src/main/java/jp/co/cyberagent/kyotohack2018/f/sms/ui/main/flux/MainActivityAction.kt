package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class MainActivityAction<T> : Action<T> {
    data class ChangeBottom(override val data: Int) : MainActivityAction<Int>()
    //data class open(override val data: HomeContent) : MainActivityAction<HomeContent>()
}