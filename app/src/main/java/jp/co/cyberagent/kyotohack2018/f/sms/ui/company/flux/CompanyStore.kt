package jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class CompanyStore(
        private val companyDispatcher: CompanyDispatcher
) : Store() {
    val company = companyDispatcher.onLoadCompany.toMapLiveData()
}