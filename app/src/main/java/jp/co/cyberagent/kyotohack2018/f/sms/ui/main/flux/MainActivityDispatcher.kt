package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toLastFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class MainActivityDispatcher : Dispatcher {
    private val dispatcherChangeBottom = PublishProcessor.create<MainActivityAction.ChangeBottom>()
    private val dispatcherLoadHomeContent = BehaviorProcessor.create<MainActivityAction.LoadHomeContent>()

    val onBottomChange = dispatcherChangeBottom.toLastFlowable()
    val onLoadHomeContent = dispatcherLoadHomeContent.toFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is MainActivityAction.ChangeBottom -> dispatcherChangeBottom.onNext(action)
            is MainActivityAction.LoadHomeContent -> dispatcherLoadHomeContent.onNext(action)
        }
    }
}