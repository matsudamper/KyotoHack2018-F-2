package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import jp.co.cyberagent.kyotohack2018.f.model.HomeContent
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class MainActivityAction<T> : Action<T> {
    data class ChangeBottom(override val data: Int) : MainActivityAction<Int>()
    data class LoadHomeContent(override val data: HomeContent) : MainActivityAction<HomeContent>()
}