package jp.co.cyberagent.kyotohack2018.f.sms.ui.company.item

import androidx.annotation.DrawableRes
import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewCompanyItemBinding

class EventItem(
        @DrawableRes val res: Int,
        val text: String
) : BindableItem<ViewCompanyItemBinding>() {

    override fun getLayout() = R.layout.view_company_item

    override fun bind(viewHolder: ViewCompanyItemBinding, p1: Int) {
        viewHolder.imageView.setImageResource(res)
        viewHolder.title.text = text
    }
}