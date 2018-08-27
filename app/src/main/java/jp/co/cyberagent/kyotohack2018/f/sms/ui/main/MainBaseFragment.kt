package jp.co.cyberagent.kyotohack2018.f.sms.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import jp.co.cyberagent.kyotohack2018.f.sms.ui.BindingFragment

abstract class MainBaseFragment<T : ViewDataBinding> : BindingFragment<T>() {

    abstract val titleResId: Int

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setTitle(titleResId)
        return binding.root
    }

    abstract fun setTitle(layoutResId: Int)
}
