package com.skyoo.keepthetime_20220315_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import com.skyoo.keepthetime_20220315_exam.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvens()
        setValues()
    }

    override fun setupEvens() {

    }

    override fun setValues() {

        var isMyINfoOk = false
        apiList.getRequestMyInfo(ContextUtil.getToken(mContext)).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {
                    isMyINfoOk = true
                }
            }
            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }
        })

        val myHandler = Handler(Looper.getMainLooper())
        myHandler.postDelayed( {
            val isAutoLogin = ContextUtil.getAutoLogin(mContext)
//            val isMyINfoOk = true  => 이것보다 더 이전에 맞는지 조회 : var로 만듬.

            if (isAutoLogin && isMyINfoOk) {
                val myIntent = Intent(mContext, MainActivity::class.java)
                startActivity(myIntent)
            }
            else {
                val myIntent = Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
            }
            finish()
        }, 2500)

    }
}