package jp.co.cyberagent.kyotohack2018.f.model

import jp.co.cyberagent.kyotohack2018.f.model.company.Company
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import java.io.Serializable

// 開催イベント
data class Event(
        val id: Long,
        val company: Company,
        val title: String,
        val description: String,
        val content: List<Content>
) : Serializable