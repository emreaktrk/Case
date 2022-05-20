package com.emreaktrk.presentation

import android.app.Activity
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

interface BindingSupport : LifecycleObserver {
    fun <T : ViewDataBinding> invoke(activity: Activity, layoutResId: Int): T {
        return DataBindingUtil.setContentView(activity, layoutResId)
    }

    fun <T : ViewDataBinding> invoke(view: View): T {
        return DataBindingUtil.bind(view)!!
    }
}

interface ViewModelSupport {
    fun <T : ViewModel> invoke(owner: ViewModelStoreOwner, vmClass: Class<T>): T {
        return ViewModelProvider(owner)[vmClass]
    }
}