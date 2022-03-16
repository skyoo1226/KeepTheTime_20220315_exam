package com.skyoo.keepthetime_20220315_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.databinding.ActivitySignUpBinding
import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// BaseActivity 만든 후 앞으로는 서버 AppCompatActivity()에서 직접 상속 받지 않고 이제는 BaseActivity에서 받을것임.
// 그러므로 BaseActivity()를 상속 받을려면, 반드시 setupEvens()와 setValues()를 써야 함. (SignUpActivity에 에러 발생)
// (SignUpActivity에 에러 발생) 에러 해결법 : SignUpActivity 에서 Alt+enter로 implement members 2개다 추가시킴.
// 그러면 아래 setupEvens()와 setValues() 코딩 필요 없이 자동 생성.
class SignUpActivity : BaseActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        setupEvens()
        setValues()
    }

    override fun setupEvens() {

        binding.btnEmailCheck.setOnClickListener {
            val inputEmail = binding.edtEmail.text.toString()

            apiList.getRequestDuplicatedCheck("EMAIL", inputEmail).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful) {      //에메일 중복이 아닐때 -성공
                        val br = response.body()!!    //response.body()!! 계속 사용하니까 br변수화 시킴
                        Toast.makeText(mContext, br.message, Toast.LENGTH_SHORT).show()
                    }
                    else {                   //이메일이 중복 됐을때 -실패
                        val jsonObj = JSONObject( response.errorBody()!!.string() )
                    }
                }
                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }
            })
        }

        binding.btnSignUp.setOnClickListener {
            val inputEmail = binding.edtEmail.text.toString()
            val inputPw = binding.edtPassword.text.toString()
            val inputNickname = binding.edtNickname.text.toString()

            apiList.putRequestSignUp(inputEmail, inputPw, inputNickname).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(mContext, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show()
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