package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux

import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class LoginDispatcher() : Dispatcher {
    private val dispatcherCreateAccount = PublishProcessor.create<LoginAction.CreateAccount>()

    val createAccount = dispatcherCreateAccount.toMapFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is LoginAction.CreateAccount -> dispatcherCreateAccount.onNext(action)
        }
    }
}