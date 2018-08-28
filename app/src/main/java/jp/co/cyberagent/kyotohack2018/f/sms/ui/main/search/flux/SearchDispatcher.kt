package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux

import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.PublishProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Dispatcher

class SearchDispatcher : Dispatcher {
    private val dispatcherLoadCategories = PublishProcessor.create<SearchAction.LoadCategories>()
    private val dispatchrSearchContents = BehaviorProcessor.create<SearchAction.SearchContents>()

    val onLoadCatogories = dispatcherLoadCategories.toFlowable()
    val onSearchContents = dispatchrSearchContents.toFlowable()

    override fun <T> dispatch(action: Action<T>) {
        when (action) {
            is SearchAction.LoadCategories -> dispatcherLoadCategories.onNext(action)
            is SearchAction.SearchContents -> dispatchrSearchContents.onNext(action)
        }
    }
}