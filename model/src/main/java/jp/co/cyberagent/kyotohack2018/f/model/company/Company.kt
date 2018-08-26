package jp.co.cyberagent.kyotohack2018.f.model.company

import jp.co.cyberagent.kyotohack2018.f.model.event.Event
import jp.co.cyberagent.kyotohack2018.f.model.event.EventCard
import java.io.Serializable


// 会社情報
data class Company(
        override val id: Long,
        override val thumbnail: String?,
        override val name: String,
        override val description: String,
        override val url: String,
        override val address: String,
        val topEvent: EventCard?,// 推したいイベント
        val events: List<EventCard>// イベント一覧
) : BaseCompany, Serializable