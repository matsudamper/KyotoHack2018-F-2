package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.flux

import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toLastFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher
import jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux.MypageAction

class MainActivityDispatcher : Dispatcher {
    private val dispatcherChangeBottom = PublishProcessor.create<MainActivityAction.ChangeBottom>()
    private val dispatcherLoadHomeContent = BehaviorProcessor.create<MainActivityAction.LoadHomeContent>()
    private val dispatcherLoadMyself = BehaviorProcessor.create<MainActivityAction.LoadMyself>()

    val onBottomChange = dispatcherChangeBottom.toLastFlowable()
    val onLoadHomeContent = dispatcherLoadHomeContent.toFlowable()
    val onLoadMyself = dispatcherLoadMyself.toFlowable()


    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is MainActivityAction.ChangeBottom -> dispatcherChangeBottom.onNext(action)
            is MainActivityAction.LoadHomeContent -> dispatcherLoadHomeContent.onNext(action)
            is MainActivityAction.LoadMyself -> dispatcherLoadMyself.onNext(action)
        }
    }
}