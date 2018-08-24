package jp.co.cyberagent.kyotohack2018.f.model.category

import java.io.Serializable


data class RootCategory(
        val id: Long,
        val categories : List<Category>
) : Serializable