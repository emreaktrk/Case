package com.emreaktrk.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding>(@LayoutRes val layoutResId: Int) : Fragment(layoutResId) {

    protected var binding: B? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (this is BindingSupport) {
            binding = invoke(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}