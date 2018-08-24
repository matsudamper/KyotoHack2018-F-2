package jp.co.cyberagent.kyotohack2018.f.model.company

import jp.co.cyberagent.kyotohack2018.f.model.Event
import java.io.Serializable


// 会社情報
data class Company(
        override val id: Long,
        override val thumbnail: String?,
        override val name: String,
        override val description: String,
        override val url: String,
        override val address: String,
        val topEvent: Event?,// 推したいイベント
        val events: List<Event>// イベント一覧
) : BaseCompany, Serializable