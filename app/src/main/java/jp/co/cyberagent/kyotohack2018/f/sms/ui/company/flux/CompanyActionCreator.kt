package jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux

import android.annotation.SuppressLint
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.CompanyRepository

class CompanyActionCreator(
        private val appActionCreator: AppActionCreator,
        private val companyDispatcher: CompanyDispatcher,
        private val companyRepository: CompanyRepository
) {

    @SuppressLint("CheckResult")
    fun loadCompany(id: Long) {
        companyRepository.getCompany(id)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    companyDispatcher.dispatch(CompanyAction.LoadCompany(it))
                }, {
                    appActionCreator.displayError(it)
                })
    }
}