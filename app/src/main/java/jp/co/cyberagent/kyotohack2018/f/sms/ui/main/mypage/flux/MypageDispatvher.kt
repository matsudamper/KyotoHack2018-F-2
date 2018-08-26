package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.flux

import io.reactivex.processors.BehaviorProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class MypageDispatvher : Dispatcher {
    private val dispatcherLoadMyself = BehaviorProcessor.create<MypageAction.LoadMyself>()

    val onLoadMyself = dispatcherLoadMyself.toFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is MypageAction.LoadMyself -> dispatcherLoadMyself.onNext(action)
        }
    }
}