package com.skyoo.keepthetime_20220315_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.databinding.ActivityManageFriendListBinding

class ManageFriendListActivity : BaseActivity() {

    lateinit var binding: ActivityManageFriendListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_friend_list)
        setupEvens()
        setValues()
    }

    override fun setupEvens() {

    }

    override fun setValues() {

    }
}