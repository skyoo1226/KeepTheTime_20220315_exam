package com.skyoo.keepthetime_20220315_exam.adapters

import android.content.Context
import com.skyoo.keepthetime_20220315_exam.datas.UserData
import android.widget.ArrayAdapter

class MyFriendAdapter(
    val mContext: Context,
    resId: Int,
    val mList: List<UserData>
) : ArrayAdapter<UserData>(mContext, resId, mList) {
}