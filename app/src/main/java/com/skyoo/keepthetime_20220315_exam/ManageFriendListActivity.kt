package com.skyoo.keepthetime_20220315_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.databinding.ActivityManageFriendListBinding
import com.skyoo.keepthetime_20220315_exam.datas.UserData
import java.util.ArrayList

class ManageFriendListActivity : BaseActivity() {

    lateinit var binding: ActivityManageFriendListBinding

    val mMyFriendList = ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_friend_list)
        setupEvens()
        setValues()
    }

    override fun setupEvens() {

    }

    override fun setValues() {
//   서버가 실제로 내려주는 친구목록을 API 통신을 이용 채운다.

    }


}
