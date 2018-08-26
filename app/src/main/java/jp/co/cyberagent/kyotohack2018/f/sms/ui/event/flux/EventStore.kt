package jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMappedLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class EventStore(
        private val eventDispatcher: EventDispatcher
) : Store() {
    val event = eventDispatcher.onLoadEvent.toMappedLiveData()
}