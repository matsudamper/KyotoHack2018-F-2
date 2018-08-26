package jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux

import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class CompanyAction<T> : Action<T> {
    data class LoadCompany(override val data: Company) : CompanyAction<Company>()
}