package jp.co.cyberagent.kyotohack2018.f.sms.ui.view

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.ext.loadUrl

class HeaderPager : PagerAdapter() {

    private var items: MutableList<ContentCard> = mutableListOf()

    fun setItem(contentCards: List<ContentCard>) {
        items.clear()
        items.addAll(contentCards)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = items[position]

        return ImageView(container.context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            loadUrl(item.thumbnail)
            setOnClickListener { onItemSelectListener?.invoke(item) }
        }.also { container.addView(it) }
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }

    override fun getCount(): Int = items.size

    var onItemSelectListener: ((ContentCard) -> Unit)? = null
}
