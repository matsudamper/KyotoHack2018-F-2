package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsMockService
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class HomeRepository() : KoinComponent {
    private val smsService: SmsMockService by inject()

    fun getHomeContent() = smsService.getHomeContent()
}