package com.emreaktrk.sahibinden.feature

import com.emreaktrk.presentation.BaseActivity
import com.emreaktrk.presentation.BindingSupport
import com.emreaktrk.sahibinden.R
import com.emreaktrk.sahibinden.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), BindingSupport {

    override val layoutResId: Int
        get() = R.layout.activity_main
}