package jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux

import io.reactivex.processors.BehaviorProcessor
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

class ArticleDispatcher {
    private val dispatcherLoadArticle = BehaviorProcessor.create<ArticleAction.LoadArticle>()

    val onArticles = dispatcherLoadArticle.toMapFlowable()

    fun <T> dispatch(action: Action<T>) {
        when (action) {
            is ArticleAction.LoadArticle -> dispatcherLoadArticle.onNext(action)
        }
    }
}