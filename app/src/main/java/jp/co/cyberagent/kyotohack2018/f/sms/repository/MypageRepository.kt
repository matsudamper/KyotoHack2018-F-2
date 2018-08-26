package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import org.koin.standalone.KoinComponent

class MypageRepository(
        private val smsService: SmsService
) : KoinComponent {

    fun getMyself() = smsService.getMyself()
}