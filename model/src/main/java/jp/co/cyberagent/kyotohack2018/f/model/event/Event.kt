package jp.co.cyberagent.kyotohack2018.f.model.event

import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import java.io.Serializable

// 開催イベント
data class Event(
        override val id: Long,
        override val companyCard: CompanyCard,
        override val title: String,
        override val description: String,
        val content: List<ContentCard>
) : Serializable, BaseEvent