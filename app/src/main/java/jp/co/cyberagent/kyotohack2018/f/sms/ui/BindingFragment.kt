package jp.co.cyberagent.kyotohack2018.f.sms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BindingFragment<T : ViewDataBinding> : Fragment() {
    abstract val layoutResId: Int
    protected lateinit var binding: T

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), layoutResId, container, false)
        return binding.root
    }
}