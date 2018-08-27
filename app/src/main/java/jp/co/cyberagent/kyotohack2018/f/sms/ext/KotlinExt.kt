package jp.co.cyberagent.kyotohack2018.f.sms.ext

inline fun <T : Any?> T.doIfNotNull(block: ((T) -> Unit)) = this.apply { if (this != null) block(this) }