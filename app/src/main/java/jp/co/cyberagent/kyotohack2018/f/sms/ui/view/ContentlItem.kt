package jp.co.cyberagent.kyotohack2018.f.sms.ui.view

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewCompanyItemBinding
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewContentItemBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl


data class ContentlItem(
        private val item: ContentCard,
        private val onClick: (() -> Unit)
) : BindableItem<ViewContentItemBinding>() {

    override fun getLayout(): Int = R.layout.view_content_item

    override fun bind(viewBinding: ViewContentItemBinding, position: Int) {
        viewBinding.title.text = item.title
        viewBinding.imageView.loadUrl(item.thumbnail)
        viewBinding.root.setOnClickListener{
            onClick()
        }
    }
}