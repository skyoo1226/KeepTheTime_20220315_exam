package com.skyoo.keepthetime_20220315_exam.api

import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT

interface APIList {
    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(
        @Field("email") id: String,
        @Field("password") pw: String,
// 임시로 써둔 Call<JSONObject> 대신 datas패키지에 만든 새로만든 클래스 <BasicResponse>로 수정
// 이제 Call은 서버의 응답 본문 (body)을, BasicResponse 클래스 형태로 자동 변환됨.
    ) : Call<BasicResponse>

    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email") email: String,
        @Field("password") pw: String,
        @Field("nick_name") nick: String,
    ) : Call<BasicResponse>
}