package jp.co.cyberagent.kyotohack2018.f.model

import java.io.Serializable


// 会社情報
data class Company(
        override val id: Long,
        override val thumbnail: String?,
        override val name: String,
        override val description: String,
        override val url: String,
        override val address: String
) : BaseCompany, Serializable