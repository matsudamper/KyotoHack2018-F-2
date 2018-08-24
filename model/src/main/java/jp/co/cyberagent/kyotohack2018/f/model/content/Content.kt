package jp.co.cyberagent.kyotohack2018.f.model.content

import jp.co.cyberagent.kyotohack2018.f.model.Category
import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import java.io.Serializable

data class Content(
        override val id: Long,
        override val company: Company,
        override val author: String,
        override val categories: List<Category>,
        override val title: String,
        override val description: String,
        override val thumbnail: String,
        override val isBookMarked: Boolean,
        override val createAt: Long,

        val slideUrls: List<String>,
        val movieUrl: String,
        val timeMap: Map<Int/* ページ数 */, Long /* 時間 */>? //スライドが無い場合はnull
) : BaseContent, Serializable