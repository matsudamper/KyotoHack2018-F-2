package jp.co.cyberagent.kyotohack2018.f.sms.repository

import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import org.koin.standalone.KoinComponent

class CompanyRepository(
        private val smsService: SmsService
) : KoinComponent {

    fun getCompany(id: Long) = smsService.getCompany(id)
}