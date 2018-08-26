package jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux

import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class EventDispatcher : Dispatcher {
    private val dispatcherLoadEvent = PublishProcessor.create<EventAction.LoadEvent>()

    val onLoadEvent = dispatcherLoadEvent.toFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is EventAction.LoadEvent -> dispatcherLoadEvent.onNext(action)
        }
    }
}