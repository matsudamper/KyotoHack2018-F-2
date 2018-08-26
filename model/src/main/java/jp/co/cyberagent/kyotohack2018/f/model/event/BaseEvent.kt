package jp.co.cyberagent.kyotohack2018.f.model.event

import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import jp.co.cyberagent.kyotohack2018.f.model.content.Content

// 開催イベント
interface BaseEvent {
    val id: Long
    val companyCard: CompanyCard
    val title: String
    val description: String
    val thumbnail: String
}