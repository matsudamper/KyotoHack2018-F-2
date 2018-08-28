package jp.co.cyberagent.kyotohack2018.f.sms.ui.post.flux

import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toLastFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class PostDispatcher : Dispatcher {
    private val dispatcherSendArticle = PublishProcessor.create<PostAction.SendArticle>()

    val onSendArticle = dispatcherSendArticle.toLastFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is PostAction.SendArticle -> dispatcherSendArticle.onNext(action)
        }
    }
}