package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.flux

import jp.co.cyberagent.kyotohack2018.f.model.category.Category
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class SearchAction<T> : Action<T> {
    data class LoadCategories(override val data: Map<String, List<Category>>) : SearchAction<Map<String, List<Category>>>()
    data class SearchContents(override val data: List<ContentCard>) : SearchAction<List<ContentCard>>()
}