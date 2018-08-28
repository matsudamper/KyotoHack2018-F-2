package jp.co.cyberagent.kyotohack2018.f.sms.ui.post.flux

import jp.co.cyberagent.kyotohack2018.f.sms.ext.toLastFlowable
import jp.co.cyberagent.kyotohack2018.f.sms.ext.toMapLiveData
import jp.co.cyberagent.kyotohack2018.f.sms.flux.Store

class PostStore(
        postDispatcher: PostDispatcher
) : Store(){
    val sendArticle = postDispatcher.onSendArticle.toMapLiveData()
}