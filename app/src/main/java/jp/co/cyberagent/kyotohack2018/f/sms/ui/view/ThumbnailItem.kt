package jp.co.cyberagent.kyotohack2018.f.sms.ui.view

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewThumbnailBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl


data class ThumbnailItem(
        private val url: String
) : BindableItem<ViewThumbnailBinding>() {

    override fun getLayout(): Int = R.layout.view_thumbnail

    override fun bind(viewBinding: ViewThumbnailBinding, position: Int) {
        viewBinding.thumbnail.loadUrl(url)
    }
}