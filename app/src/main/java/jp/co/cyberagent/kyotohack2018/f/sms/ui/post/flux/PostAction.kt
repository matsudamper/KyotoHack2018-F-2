package jp.co.cyberagent.kyotohack2018.f.sms.ui.post.flux

import jp.co.cyberagent.kyotohack2018.f.model.PostArticle
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action

sealed class PostAction<T> : Action<T>{
    data class SendArticle(override val data : PostArticle) : PostAction<PostArticle>()
}