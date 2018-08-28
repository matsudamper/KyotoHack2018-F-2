package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewPlayCompanyBinding
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewPlayDescriptionBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl


class PlayCompanyItem(
        private val companyCard: CompanyCard,
        private val onClick: (() -> Unit)
) : BindableItem<ViewPlayCompanyBinding>() {
    override fun getLayout() = R.layout.view_play_company

    override fun bind(viewHolder: ViewPlayCompanyBinding, p1: Int) {
        val imageUrl = companyCard.thumbnail
        if (imageUrl != null && imageUrl.isNotEmpty()){
            viewHolder.imageView.loadUrl(imageUrl)
        }

        viewHolder.description.text = companyCard.name
        
        viewHolder.root.setOnClickListener {
            onClick()
        }
    }
}