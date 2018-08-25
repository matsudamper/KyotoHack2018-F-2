package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class HomeRepository() : KoinComponent {
    private val smsService: SmsService by inject()

    fun getHomeContent() = smsService.getHomeContent()
}