package com.skyoo.keepthetime_20220315_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvens()
        setValues()
    }

    override fun setupEvens() {

    }

    override fun setValues() {

    }
}