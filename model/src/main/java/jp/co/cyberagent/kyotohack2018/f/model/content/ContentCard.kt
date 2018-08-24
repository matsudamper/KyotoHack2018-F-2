package jp.co.cyberagent.kyotohack2018.f.model

import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import java.io.Serializable

// 再生に必要な情報
data class ContentCard(
        override val id: Long,
        override val company: Company,
        override val author: String,
        override val categories: List<Category>,
        override val title: String,
        override val description: String,
        override val thumbnail: String,
        override val isBookMarked: Boolean,
        override val createAt: Long
) : ContentBase, Serializable