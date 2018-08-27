package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService

class ContentRepository(private val smsService: SmsService) {

    fun getContent(id: Long) = smsService.getContent(id)
}