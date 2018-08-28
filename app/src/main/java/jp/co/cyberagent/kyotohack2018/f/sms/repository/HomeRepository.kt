package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import org.koin.standalone.KoinComponent

class HomeRepository(
        private val smsService: SmsService
) : KoinComponent {

    fun getHomeContent() = smsService.getHomeContent()
    fun getArticle(uid :String) = smsService.getArticlesByUID(uid)
}