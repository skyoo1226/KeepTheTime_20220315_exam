package com.skyoo.keepthetime_20220315_exam.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.skyoo.keepthetime_20220315_exam.fragmens.AppointmentListFragment
import com.skyoo.keepthetime_20220315_exam.fragmens.MyFriendListFragment
import com.skyoo.keepthetime_20220315_exam.fragmens.MyProfileFragment
import com.skyoo.keepthetime_20220315_exam.fragmens.RequestedUserListFragment

class FriendViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount() = 2

    override fun getItem(position: Int): Fragment {

        return when(position) {
            0 -> MyFriendListFragment()
            else -> RequestedUserListFragment()
        }
    }
//페이지 제목 부분
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "내 친구 목록"
            else -> "친구 요청 목록"
        }
    }
}