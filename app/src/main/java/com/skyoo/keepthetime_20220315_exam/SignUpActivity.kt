package com.skyoo.keepthetime_20220315_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.databinding.ActivitySignUpBinding


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
        binding.btnSignUp.setOnClickListener {
            val inputEmail = binding.edtEmail.text.toString()
            val inputPw = binding.edtPassword.text.toString()
            val inputNickname = binding.edtNickname.text.toString()


        }

    }

    override fun setValues() {

    }
}