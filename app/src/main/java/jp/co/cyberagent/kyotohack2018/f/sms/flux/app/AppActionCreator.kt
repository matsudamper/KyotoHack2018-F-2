package jp.co.cyberagent.kyotohack2018.f.sms.flux.app

import android.content.Context
import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.model.event.EventCard
import jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.ArticleActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.CompanyActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.ContentActivity
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.EventActivity

class AppActionCreator {

    fun openContent(context: Context?, content: ContentCard) {
        context?.startActivity(ContentActivity.createIntent(context, content))
    }

    fun openEvent(context: Context?, eventCard: EventCard) {
        context?.startActivity(EventActivity.createIntent(context, eventCard))
    }

    fun openCompany(context: Context?, companyCard: CompanyCard){
        context?.startActivity(CompanyActivity.createIntent(context, companyCard))
    }

    fun openArticle(context: Context?, content : Content){
        context?.startActivity(ArticleActivity.createIntent(context, content))
    }
}