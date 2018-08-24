package jp.co.cyberagent.kyotohack2018.f.data

import java.io.Serializable

// 開催イベント
data class Event(
        val id: Long,
        val company: Company,
        val title: String,
        val description: String,
        val content: List<Content>
) : Serializable