package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import org.koin.standalone.KoinComponent

class EventRepository(
        private val smsService: SmsService
) : KoinComponent {

    fun getEvent(id: Long) = smsService.getEvent(id)
}