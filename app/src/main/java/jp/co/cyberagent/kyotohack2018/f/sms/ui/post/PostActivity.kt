package jp.co.cyberagent.kyotohack2018.f.sms.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import jp.co.cyberagent.kyotohack2018.f.android_lib.bundle
import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.service.SmsService
import jp.co.cyberagent.kyotohack2018.f.sms.R
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ActivityPostBinding
import jp.co.cyberagent.kyotohack2018.f.sms.databinding.ViewPostPageBinding
import jp.co.cyberagent.kyotohack2018.f.sms.repository.AuthRepository
import org.koin.android.ext.android.inject

class PostActivity : AppCompatActivity() {

    private val content: Content by bundle()
    private val sms: SmsService by inject()

    companion object {
        fun createIntent(context: Context?, content: Content) = Intent(context, PostActivity::class.java).apply {
            putExtra(PostActivity::content.name, content)
        }
    }

    private val binding by lazy {
        DataBindingUtil.inflate<ActivityPostBinding>(LayoutInflater.from(this), R.layout.activity_post, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolBar.title = "投稿"

        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            add(PostAdapter())
        }
    }

    inner class PostAdapter() : BindableItem<ViewPostPageBinding>() {

        override fun getLayout() = R.layout.view_post_page

        override fun bind(viewHolder: ViewPostPageBinding, p1: Int) {

            viewHolder.send.setOnClickListener {
                if (AuthRepository.uuid == null) {
                    Toast.makeText(this@PostActivity, "投稿をするにはTOPよりログインして下さい", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
//                sms.createArticle(Article(
//                        description = viewHolder.description.text.toString(),
//                        url = viewHolder.postUrl.text.toString(),
//                        title = viewHolder.postTitle.text.toString(),
//                        contentId = ,
//                        thumbnail = ,
//                        id =
//                )).subscribeOn(Schedulers.io())
            }
        }
    }
}