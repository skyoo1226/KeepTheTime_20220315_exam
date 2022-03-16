package com.skyoo.keepthetime_20220315_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.databinding.ActivityMainBinding
import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import com.skyoo.keepthetime_20220315_exam.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
/**
//        임시 연습문제용 3월13일 3:47:39 내용
//        서버에서 유저정보(토큰값 포함)을 가져오고, 기기에 저장한 것을 ContextUtil을 통해 가져옴
        apiList.getRequestMyInfo(ContextUtil.getToken(mContext)).enqueue(object :Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {
                    val br = response.body()!!
                    binding.txtMyNickname.text = br.data.user.nick_name
                }
            }
            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
            }
        })
 **/
    }

}