package jp.co.cyberagent.kyotohack2018.f.data

// 再生に必要な情報
data class ContentPlayInfo(
        val slideUrls: List<String>,
        val movieUrl: String,
        val timeMap: Map<Int/* ページ数 */, Long /* 時間 */>? //スライドが無い場合はnull
)