package jp.co.cyberagent.kyotohack2018.f.model.company

interface BaseCompany {
    val id: Long
    val thumbnail: String?
    val name: String
    val description: String
    val url: String
    val address: String
}