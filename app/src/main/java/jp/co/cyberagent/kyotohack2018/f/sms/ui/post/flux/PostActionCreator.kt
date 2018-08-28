package jp.co.cyberagent.kyotohack2018.f.sms.ui.post.flux

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.schedulers.Schedulers
import jp.co.cyberagent.kyotohack2018.f.model.PostArticle
import jp.co.cyberagent.kyotohack2018.f.sms.flux.app.AppActionCreator
import jp.co.cyberagent.kyotohack2018.f.sms.repository.ArticleRepository

class PostActionCreator(
        private val appActionCreator: AppActionCreator,
        private val articleRepository: ArticleRepository,
        private val postDispatcher: PostDispatcher
) {
    @SuppressLint("CheckResult")
    fun sendArticle(postArticle: PostArticle) {
        articleRepository.sendArticle(postArticle)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    postDispatcher.dispatch(PostAction.SendArticle(it))
                }, {
                    appActionCreator.displayError(it)
                })
    }

    fun sended(activity: AppCompatActivity) {
        Toast.makeText(activity, "送信完了しました", Toast.LENGTH_SHORT).show()
        activity.finish()

    }
}