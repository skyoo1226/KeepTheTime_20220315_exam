package com.skyoo.keepthetime_20220315_exam.datas

class DataResponse(
    val user: UserData, // 로그인, 회원가입 API가 호출되면 사용할 데이터.
    val token: String,

    val friends: List<UserData>,  // [친구목록API가 호출되면 사용할 데이터임]UserData클래스를 가져다 쓴다. 왜냐하면 데이터항목이 비슷하므로


) {
}