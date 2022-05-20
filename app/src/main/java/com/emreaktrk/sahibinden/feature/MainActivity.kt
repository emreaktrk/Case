package com.emreaktrk.sahibinden.feature

import com.emreaktrk.presentation.BaseActivity
import com.emreaktrk.presentation.BindingSupport
import com.emreaktrk.sahibinden.R
import com.emreaktrk.sahibinden.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(), BindingSupport {

    override val layoutResId: Int
        get() = R.layout.activity_main
}