package jp.co.cyberagent.kyotohack2018.f.data


// ホーム画面で欲しいやつ
data class HomeContent(
        val banners : List<Content>,// おすすめしたいLT単体（ここは決め打ち）
        val rankings : List<Content>,// 今人気のLT単体(最近)
        val newContent : List<Event>,// 新着イベント
        val histories : List<Content>// 最近見たLT
)