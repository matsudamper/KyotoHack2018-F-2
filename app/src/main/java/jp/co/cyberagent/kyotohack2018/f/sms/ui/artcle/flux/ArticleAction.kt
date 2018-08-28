package jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.flux

import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class ArticleAction<T> : Action<T> {
    data class LoadArticle(override val data: List<Article>) : ArticleAction<List<Article>>()
}
