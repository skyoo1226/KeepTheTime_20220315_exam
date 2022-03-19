package com.skyoo.keepthetime_20220315_exam.fragmens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skyoo.keepthetime_20220315_exam.R

class MyFriendListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_friend_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }

}