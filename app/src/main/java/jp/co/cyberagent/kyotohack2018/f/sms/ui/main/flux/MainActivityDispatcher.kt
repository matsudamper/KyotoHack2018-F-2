package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import io.reactivex.processors.BehaviorProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toLastFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class MainActivityDispatcher : Dispatcher {
    private val dispatcherChangeBottom = BehaviorProcessor.create<MainActivityAction.ChangeBottom>()

    val onBottomChange = dispatcherChangeBottom.toLastFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is MainActivityAction.ChangeBottom -> dispatcherChangeBottom.onNext(action)
        }
    }
}