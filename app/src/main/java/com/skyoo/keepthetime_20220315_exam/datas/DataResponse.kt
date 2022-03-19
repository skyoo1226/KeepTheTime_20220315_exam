package com.skyoo.keepthetime_20220315_exam.datas

class DataResponse(
    val user: UserData,
    val token: String,

    val friends: List<UserData>,
) {
}