package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.login.flux

import jp.co.cyberagent.kyotohack2018.f.service.sms.RegistUser
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class LoginAction<T> : Action<T>{
    data class CreateAccount(override val data : RegistUser) : LoginAction<RegistUser>()
}