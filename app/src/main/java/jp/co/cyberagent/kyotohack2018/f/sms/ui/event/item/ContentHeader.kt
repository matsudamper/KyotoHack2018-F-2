package jp.co.cyberagent.kyotohack2018.f.sms.ui.event.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewCompanyHeaderBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl

class ContentHeader(
        val item : CompanyCard
) : BindableItem<ViewCompanyHeaderBinding>() {

    override fun getLayout() = R.layout.view_company_header

    override fun bind(viewHolder: ViewCompanyHeaderBinding, p1: Int) {
        viewHolder.companyName.text = item.name
        viewHolder.header.loadUrl(item.thumbnail ?: "")
        viewHolder.icon.loadUrl(item.thumbnail ?: "") // TODO
        viewHolder.companyDescription.text = item.description
    }
}