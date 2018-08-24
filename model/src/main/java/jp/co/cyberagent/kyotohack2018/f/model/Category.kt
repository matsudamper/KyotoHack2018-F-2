package jp.co.cyberagent.kyotohack2018.f.model

import java.io.Serializable


data class Category(
        val id: Long,
        val name: String,
        val categories : List<Category>?
) : Serializable