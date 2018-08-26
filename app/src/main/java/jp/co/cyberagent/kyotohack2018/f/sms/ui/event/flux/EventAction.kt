package jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux

import jp.co.cyberagent.kyotohack2018.f.model.event.Event
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class EventAction<T> : Action<T> {
    data class LoadEvent(override val data: Event) : EventAction<Event>()
}