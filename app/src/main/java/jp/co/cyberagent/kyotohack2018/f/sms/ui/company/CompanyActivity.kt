package jp.co.cyberagent.kyotohack2018.f.sms.ui.company

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.android_lib.bundle
import jp.co.cyberagent.kyotohack2018.f.model.company.CompanyCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivitySubBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.flux.CompanyStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.item.ContentHeader
import jp.co.cyberagent.kyotohack2018.f.sms.ui.company.item.EventItem
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderData
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.slider.SliderHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyActivity : AppCompatActivity() {

    private val companyCard: CompanyCard by bundle()
    private val companyActionCreator: CompanyActionCreator by inject()
    private val appActionCreator: AppActionCreator by inject()
    private val companyStore: CompanyStore by viewModel()

    companion object {
        fun createIntent(context: Context?, companyCard: CompanyCard) = Intent(context, CompanyActivity::class.java).apply {
            putExtra(CompanyActivity::companyCard.name, companyCard)
        }
    }

    private val binding by lazy {
        DataBindingUtil.inflate<ActivitySubBinding>(LayoutInflater.from(this), R.layout.activity_sub, null, false)
    }

    private val groupAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolBar.title = "イベント運営"

        createView()

        companyStore.company
                .doIfNull { companyActionCreator.loadCompany(companyCard.id) }
                .observeNotNull(this) { item ->
                    binding.recyclerView.adapter = groupAdapter.apply {
                        add(SliderHolder("イベント一覧", item.events.map { SliderData(it.title, it.thumbnail, it) }) {
                            appActionCreator.openEvent(this@CompanyActivity, it)
                        })
                    }
                }
    }

    private fun createView() {
        binding.recyclerView.adapter = groupAdapter.apply {
            add(ContentHeader(companyCard))
            add(EventItem(android.R.drawable.alert_dark_frame, companyCard.address))
            add(EventItem(android.R.drawable.alert_dark_frame, companyCard.url))
        }
    }
}
