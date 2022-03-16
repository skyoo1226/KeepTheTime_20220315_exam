package com.skyoo.keepthetime_20220315_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.api.APIList
import com.skyoo.keepthetime_20220315_exam.api.ServerAPI
import com.skyoo.keepthetime_20220315_exam.databinding.ActivityLoginBinding
import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupEvents()
        setValues()
    }
    fun setupEvents() {

        binding.btnSignUp.setOnClickListener {
            val myIntent = Intent(this, SignUpActivity::class.java)
            startActivity(myIntent)
        }

        binding.btnLogin.setOnClickListener {
            val inputID = binding.edtEmail.text.toString()
            val inputPw = binding.edtPassword.text.toString()

            val myRetrofit = ServerAPI.getRetrofit()
            val myApiList = myRetrofit.create(APIList::class.java)

            myApiList.postRequestLogin(inputID, inputPw).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                    if (response.isSuccessful) {
                        val br = response.body()!!
                        Toast.makeText(this@LoginActivity, br.message, Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }
            })
        }
    }
    fun setValues() {
    }
}