package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.home.item

import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.model.content.ContentCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewHeaderSliderBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.println
import jp.co.cyberagent.kyotohack2018.f.sms.ui.content.cast
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.HeaderPager


class HeaderSlider(
        val header: List<ContentCard>
) : BindableItem<ViewHeaderSliderBinding>() {

    val adapter by lazy { HeaderPager().apply { setItem(header) } }

    override fun getLayout() = R.layout.view_header_slider

    override fun bind(viewHolder: ViewHeaderSliderBinding, p1: Int) {

        viewHolder.viewPager.adapter = adapter

        viewHolder.viewPager.postDelayed(getPageSlideAction(viewHolder.viewPager), 4000)
        viewHolder.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                val handler = viewHolder.viewPager.handler

                // MEMO 色々βでコールーチン使えない
                if (state == 0) {
                    handler?.postDelayed(getPageSlideAction(viewHolder.viewPager), 4000)
                } else {
                    handler?.removeCallbacksAndMessages(null)
                }
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {}
        })
    }

    fun getPageSlideAction(viewPager: ViewPager) = Runnable {
        if (viewPager.currentItem + 2 <= adapter.cast(HeaderPager::class.java).count) {
            viewPager.currentItem++
        } else {
            viewPager.currentItem = 0
        }
    }
}