package jp.co.cyberagent.kyotohack2018.f.sms.ui.content.flux

import jp.co.cyberagent.kyotohack2018.f.model.content.Content
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Action


sealed class ContentAction<T> : Action<T> {
    data class LoadContent(override val data: Content) : ContentAction<Content>()
}