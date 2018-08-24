package jp.co.cyberagent.kyotohack2018.f.data


// 会社情報
data class CompanyEvent(
        val id: Long,
        val thumbnail : String?,// Url
        val topEvent: Event?,// 推したいイベント
        val events: List<Event>// イベント一覧
)