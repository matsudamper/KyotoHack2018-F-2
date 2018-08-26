package jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux

import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class CompanyDispatcher : Dispatcher {
    private val dispatcherLoadCompany = PublishProcessor.create<CompanyAction.LoadCompany>()

    val onLoadCompany = dispatcherLoadCompany.toFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is CompanyAction.LoadCompany -> dispatcherLoadCompany.onNext(action)
        }
    }
}