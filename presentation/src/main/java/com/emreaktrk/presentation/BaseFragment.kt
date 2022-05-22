package com.emreaktrk.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding>(@LayoutRes val layoutResId: Int) :
    Fragment(layoutResId) {

    protected var binding: B? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (this is BindingSupport) {
            binding = invoke(view)

            with(requireBinding()) {
                if (this is ViewDataBinding) {
                    this.lifecycleOwner = this@BaseFragment
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun requireBinding(): B {
        if (this is BindingSupport) {
            return binding!!
        }

        throw UnsupportedOperationException("Missing BindingSupport")
    }
}