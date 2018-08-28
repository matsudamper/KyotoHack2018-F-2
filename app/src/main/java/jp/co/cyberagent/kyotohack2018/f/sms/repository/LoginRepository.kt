package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import jp.co.cyberagent.kyotohack2018.f.service.sms.RegistUser

class LoginRepository(
        private val smsService: SmsService
) {

    fun createAccount(user : RegistUser) = smsService.createUser(user)
}