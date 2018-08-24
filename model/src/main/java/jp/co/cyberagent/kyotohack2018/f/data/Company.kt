package jp.co.cyberagent.kyotohack2018.f.data

import java.io.Serializable


// 会社情報
data class Company(
        val id: Long,
        val thumbnail: String?,// Url
        val name: String,
        val description: String,
        val url: String,
        val address: String
) : Serializable