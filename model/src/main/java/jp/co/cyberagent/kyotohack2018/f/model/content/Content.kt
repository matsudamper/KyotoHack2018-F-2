package jp.co.cyberagent.kyotohack2018.f.model.content

import jp.co.cyberagent.kyotohack2018.f.model.category.RootCategory
import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import java.io.Serializable

data class Content(
        override val id: Long,
        override val company: CompanyCard,
        override val author: String,
        override val categories: List<RootCategory>,
        override val title: String,
        override val description: String,
        override val thumbnail: String,
        override val isBookMarked: Boolean,
        override val createAt: Long,

        val slideUrls: List<String>,
        val movieUrl: String,
        val timeMap: Map<Int/* ページ数 */, Long /* 時間 */>? //スライドが無い場合はnull
) : BaseContent, Serializable