package jp.co.cyberagent.kyotohack2018.f.model

import java.io.Serializable


// 自分のユーザー情報
data class Myself(
        val id: Long,
        val name: String,
        val posts: List<Article>,
        val createAt: Long
) : Serializable