package com.skyoo.keepthetime_20220315_exam.fragmens

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.skyoo.keepthetime_20220315_exam.R
import com.skyoo.keepthetime_20220315_exam.SplashActivity
import com.skyoo.keepthetime_20220315_exam.databinding.FragmentMyprofileBinding
import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import com.skyoo.keepthetime_20220315_exam.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileFragment : BaseFragment() {

    lateinit var binding: FragmentMyprofileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//  return inflater.inflate(R.layout.fragment_myprofile, container, false) -> 서버에서 id 이미지를 가지고 와 표시할때 필요 없음. 다른것으로 수정.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_myprofile, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.btnLogout.setOnClickListener {
//      AlertDialog 자동완성 시 필히 AlertDialog(androidx.appcompat.app) 선택

//      강사임 화면은 val alert = AlertDialog.Builder(mContext) 나와 왜 차이날까?
            val alert = androidx.appcompat.app.AlertDialog.Builder(mContext)
                .setTitle("로그아웃")
                .setMessage("정말 로그아웃 하시겠습니까?")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->

//      실제 로그아웃 처리 = 저장된 토큰값을 삭제 : ""로 표현. -> 화면 종료 후 로딩화면으로 이동.
                    ContextUtil.setToken(mContext, "")

                    val myIntent = Intent(mContext, SplashActivity::class.java)
                    startActivity(myIntent)

                    requireActivity().finish()

                })
                .setNegativeButton("취소", null)
                .show()
        }

    }

    override fun setValues() {
//  내정보를 프래그먼트에서 받아와 => 프로필 사진 표시하려고 함.
        apiList.getRequestMyInfo(ContextUtil.getToken(mContext)).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {
                    val  br = response.body()!!
//          내 정보를 받아온 사용자의 프로필 사진을 Glide를 활용 -> 이미지뷰에 반영 하여 함.
                    Glide.with(mContext).load(br.data.user.profile_img).into(binding.imgProfile)
//          fragment_myprofile의 닉네임에 id 부여 후 닉네일도 서버에서 가져오기.
                    binding.txtNickname.text = br.data.user.nick_name
                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

    }

}