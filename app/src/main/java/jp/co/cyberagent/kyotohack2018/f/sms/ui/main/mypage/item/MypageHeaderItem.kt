package jp.co.cyberagent.kyotohack2018.f.sms.ui.main.mypage.item

import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.FragmentViewMypageHeaderBinding

class MypageHeaderItem(
        private val onClick: (() -> Unit)
) : BindableItem<FragmentViewMypageHeaderBinding>() {
    override fun getLayout() = R.layout.fragment_view_mypage_header

    override fun bind(viewHolder: FragmentViewMypageHeaderBinding, p1: Int) {

        viewHolder.button.setOnClickListener {
            onClick()
        }
    }

}