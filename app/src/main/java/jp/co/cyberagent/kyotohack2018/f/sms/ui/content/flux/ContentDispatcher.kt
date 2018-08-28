package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux

import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class ContentDispatcher : Dispatcher {
    private val dispatcherLoadContent = BehaviorProcessor.create<ContentAction.LoadContent>()
    private val dispatcherSendHistory = PublishProcessor.create<ContentAction.SendHistory>()

    val onLoadContent = dispatcherLoadContent.toFlowable()
    val onSendHistory = dispatcherSendHistory.toFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is ContentAction.LoadContent -> dispatcherLoadContent.onNext(action)
            is ContentAction.SendHistory-> dispatcherSendHistory.onNext(action)
        }
    }
}