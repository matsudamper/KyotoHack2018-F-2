package jp.co.cyberagent.kyotohack2018.f.model

import java.io.Serializable


// 投稿記事
data class Article(
        val id: Long,
        val contentId: Long,
        val title: String,
        val description: String,
        val thumbnail: String,
        val url: String
) : Serializable