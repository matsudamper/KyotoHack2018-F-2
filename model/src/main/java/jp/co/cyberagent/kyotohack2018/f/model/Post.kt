package jp.co.cyberagent.kyotohack2018.f.data

import java.io.Serializable


// 投稿記事
data class Post(
        val id: Long,
        val contentId: Long,
        val title: String,
        val description: String,
        val thumbnail: String,
        val url: String
) : Serializable