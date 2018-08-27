package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toLastFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class LoginStore(
        loginDispatcher: LoginDispatcher
) : Store() {

    val createAccount = loginDispatcher.createAccount.toLastFlowable()
}