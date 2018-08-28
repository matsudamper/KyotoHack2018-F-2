package jp.co.cyberagent.kyotohack2018.f.sms.ui.artcle.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.Article
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewPostContentBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl

class ArticleItem(
        val article: Article,
        val onClick: (() -> Unit)
) : BindableItem<ViewPostContentBinding>() {

    override fun getLayout() = R.layout.view_post_content

    override fun bind(viewHolder: ViewPostContentBinding, p1: Int) {
        viewHolder.title.text = article.title
        viewHolder.url.text = article.url
        viewHolder.img.loadUrl(article.thumbnail)
        viewHolder.root.setOnClickListener {
            onClick()
        }
    }
}