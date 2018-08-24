package jp.co.cyberagent.kyotohack2018.f.data


// 会社情報
data class Company(
        val id: Long,
        val name: String,
        val description: String,
        val url: String,
        val topEvent: Event,// 推したいイベント
        val events: List<Event>,// イベント一覧
        val adress: String
)