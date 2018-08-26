package jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMappedLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventDispatcher

class CompanyStore(
        private val companyDispatcher: CompanyDispatcher
) : Store() {
    val company = companyDispatcher.onLoadCompany.toMappedLiveData()
}