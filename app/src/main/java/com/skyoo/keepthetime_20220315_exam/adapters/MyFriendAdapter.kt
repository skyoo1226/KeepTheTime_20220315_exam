package com.skyoo.keepthetime_20220315_exam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skyoo.keepthetime_20220315_exam.datas.UserData
import android.widget.ArrayAdapter
import com.skyoo.keepthetime_20220315_exam.R

class MyFriendAdapter(
    val mContext: Context,
    resId: Int,
    val mList: List<UserData>
) : ArrayAdapter<UserData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.friend_list_item, null)
        }
        val row = tempRow!!

        return row

    }
}