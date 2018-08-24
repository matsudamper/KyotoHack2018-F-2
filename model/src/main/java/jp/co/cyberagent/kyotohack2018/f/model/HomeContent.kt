package jp.co.cyberagent.kyotohack2018.f.model

import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import java.io.Serializable


// ホーム画面で欲しいやつ
data class HomeContent(
        val banners: List<ContentCard>,// おすすめしたいLT単体（ここは決め打ち）
        val rankings: List<ContentCard>,// 今人気のLT単体(最近)
        val newContent: List<ContentCard>,// 新着イベント
        val histories: List<ContentCard>// 最近見たLT
) : Serializable