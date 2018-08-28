package jp.co.cyberagent.kyotohack2018.f.model

data class PostArticle(
        val title: String,
        val description: String,
        val uid: String,
        val contentId: Long,
        val thumbnail: String,
        val url: String
)