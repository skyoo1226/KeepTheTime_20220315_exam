package com.skyoo.keepthetime_20220315_exam.fragmens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.skyoo.keepthetime_20220315_exam.R
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

    }

    override fun setValues() {
//  내정보를 프래그먼트에서 받아와 => 프로필 사진 표시하려고 함.
        apiList.getRequestMyInfo(ContextUtil.getToken(mContext)).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {
                    val  br = response.body()!!
//          내 정보를 받아온 사용자의 프로필 사진을 Glide를 활용 -> 이미지뷰에 반영 하여 함.
                    Glide.with(mContext).load(br.data.user.profile_img).into(binding.imgProfile)
                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

    }

}