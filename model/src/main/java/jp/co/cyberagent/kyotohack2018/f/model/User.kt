package jp.co.cyberagent.kyotohack2018.f.model

import java.io.Serializable


// 自分のユーザー情報
data class User(
        val id: Long,
        val name: String,
        val posts: List<Article>,
        val createAt: Long
//        val githubStatus : GitHubStatus,// ログインで得られるGitHubの情報によってデータクラスを作る
) : Serializable