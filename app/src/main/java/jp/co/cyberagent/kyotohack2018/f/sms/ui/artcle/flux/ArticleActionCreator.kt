package jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux

import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.ArticleRepository

class ArticleActionCreator(
        private val appActionCreator: AppActionCreator,
        private val artiDispatcher: ArticleDispatcher,
        private val articleRepository: ArticleRepository
) {

    fun loadArticles(id: Long) {
        articleRepository.getArticles(id)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    artiDispatcher.dispatch(ArticleAction.LoadArticle(it))
                }, {
                    appActionCreator.displayError(it)
                })
    }
}