package com.skyoo.keepthetime_20220315_exam.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.skyoo.keepthetime_20220315_exam.fragmens.AppointmentListFragment
import com.skyoo.keepthetime_20220315_exam.fragmens.MyProfileFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount() = 2

    override fun getItem(position: Int): Fragment {

        return when(position) {
            0 -> AppointmentListFragment()
            else -> MyProfileFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "약속 목록"
            else -> "내 프로필"
        }
    }
}