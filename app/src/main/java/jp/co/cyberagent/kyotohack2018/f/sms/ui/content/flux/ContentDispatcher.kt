package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux

import io.reactivex.processors.BehaviorProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class ContentDispatcher : Dispatcher {
    private val dispatcherLoadContent = BehaviorProcessor.create<ContentAction.LoadContent>()

    val onLoadContent = dispatcherLoadContent.toFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is ContentAction.LoadContent -> dispatcherLoadContent.onNext(action)
        }
    }
}