package jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class EventStore(
        eventDispatcher: EventDispatcher
) : Store() {
    val event = eventDispatcher.onLoadEvent.toMapLiveData()
}