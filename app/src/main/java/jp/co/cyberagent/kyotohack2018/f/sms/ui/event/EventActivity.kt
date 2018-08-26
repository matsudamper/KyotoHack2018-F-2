package jp.co.cyberagent.kyotohack2018.f.sms.ui.event

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.co.cyberagent.kyotohack2018.f.android_lib.bundle
import jp.co.cyberagent.kyotohack2018.f.model.event.EventCard
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivitySubBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ext.doIfNull
import jp.co.cyberagent.kyotohack2018.f.sms.ext.observeNotNull
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.ui.event.flux.EventStore
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.ContentlItem
import jp.co.cyberagent.kyotohack2018.f.sms.ui.view.ThumbnailItem
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventActivity : AppCompatActivity() {

    private val eventCard: EventCard by bundle()
    private val eventActionCreator: EventActionCreator by inject()
    private val appActionCreator: AppActionCreator by inject()
    private val eventStore: EventStore by viewModel()

    companion object {
        fun createIntent(context: Context?, eventCard: EventCard) = Intent(context, EventActivity::class.java).apply {
            putExtra(EventActivity::eventCard.name, eventCard)
        }
    }

    private val binding by lazy {
        DataBindingUtil.inflate<ActivitySubBinding>(LayoutInflater.from(this), R.layout.activity_sub, null, false)
    }

    private val groupAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolBar.title = eventCard.title

        createView()

        eventStore.event
                .doIfNull { eventActionCreator.loadEvent(eventCard.id) }
                .observeNotNull(this) { item ->
                    binding.recyclerView.swapAdapter(groupAdapter.apply {
                        item.content.forEach {
                            add(ContentlItem(it) {
                                appActionCreator.openContent(this@EventActivity, it)
                            })
                        }
                    }, false)
                }
    }

    private fun createView() {
        binding.recyclerView.adapter = groupAdapter.apply {
            add(ThumbnailItem(eventCard.thumbnail))
        }
    }
}
