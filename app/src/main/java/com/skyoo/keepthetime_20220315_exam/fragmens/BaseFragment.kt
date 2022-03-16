package com.skyoo.keepthetime_20220315_exam.fragmens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.skyoo.keepthetime_20220315_exam.api.APIList
import com.skyoo.keepthetime_20220315_exam.api.ServerAPI

abstract class BaseFragment : Fragment() {

    lateinit var mContext: Context

    lateinit var apiList: APIList

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mContext = requireContext()

        val retrofit = ServerAPI.getRetrofit()
        apiList = retrofit.create(APIList::class.java)
    }

    abstract fun setupEvents()
    abstract fun setValues()
}