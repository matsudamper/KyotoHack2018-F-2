package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.search.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewCategoryHeaderBinding

class CategoryHeader(
        private val title: String
) : BindableItem<ViewCategoryHeaderBinding>() {
    override fun getLayout() = R.layout.view_category_header

    override fun bind(viewHolder: ViewCategoryHeaderBinding, p1: Int) {
        viewHolder.title.text = title
    }
}