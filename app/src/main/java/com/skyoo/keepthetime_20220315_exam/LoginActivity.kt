package com.skyoo.keepthetime_20220315_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.api.APIList
import com.skyoo.keepthetime_20220315_exam.api.ServerAPI
import com.skyoo.keepthetime_20220315_exam.databinding.ActivityLoginBinding
import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import com.skyoo.keepthetime_20220315_exam.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {

        binding.autoLoginCheckBox.setOnCheckedChangeListener { compoundButton, isChecked ->
            ContextUtil.setAutoLogin(mContext, isChecked)
        }

        binding.btnSignUp.setOnClickListener {
//  => BaseActivity를 상속 받기 때문에 this 대신에 mContext로 써야 됨.
            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)
        }

        binding.btnLogin.setOnClickListener {
            val inputID = binding.edtEmail.text.toString()
            val inputPw = binding.edtPassword.text.toString()

//  val myRetrofit = ServerAPI.getRetrofit()  => BaseActivity를 상속 받기 때문에 삭제
//  val myApiList = myRetrofit.create(APIList::class.java) => BaseActivity를 상속 받기 때문에 삭제
// 그리고 myApiList 는 그냥 apiList 변수로 쓰면 됨.
            apiList.postRequestLogin(inputID, inputPw).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                    if (response.isSuccessful) {
                        val br = response.body()!!
//  또한 this@LoginActivity 도 mContext로 대체 해야 함.
//  필요없어져서 주석처리 함. Toast.makeText(mContext, br.message, Toast.LENGTH_SHORT).show()
                        Log.d("토큰", br.data.token)

                        Toast.makeText(
                            mContext,
                            "${br.data.user.nick_name}님, 환영합니다!",
                            Toast.LENGTH_SHORT
                        ).show()
//                        로그인화면 종료 후 메인화면(새로 만들어야 함)으로 이동.
                        val myIntent = Intent(mContext, MainActivity::class.java)
                        startActivity(myIntent)

                        finish()
                    }
                }
                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }
            })
        }
    }
    override fun setValues() {
    }
}