package com.emreaktrk.presentation

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>(@LayoutRes protected val contentLayoutId: Int) :
    AppCompatActivity(contentLayoutId) {

    private lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (this is BindingSupport) {
            binding = invoke(this, contentLayoutId)
        }
    }

    private fun binding(): B {
        if (this is ViewModelSupport) {
            return binding
        } else {
            throw IllegalStateException("${this::class.simpleName} does not support Binding")
        }
    }
}