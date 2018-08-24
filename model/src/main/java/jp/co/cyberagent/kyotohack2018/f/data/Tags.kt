package jp.co.cyberagent.kyotohack2018.f.data

import java.io.Serializable


data class Tags(
        val id: Long,
        val name: String,
        val tags: List<Tag>
) : Serializable
