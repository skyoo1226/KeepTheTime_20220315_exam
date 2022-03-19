package com.skyoo.keepthetime_20220315_exam.api

import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface APIList {

//    로그인 확인 : POST-FormData방식이므로 Field 사용
    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(
        @Field("email") id: String,
        @Field("password") pw: String,
// 임시로 써둔 Call<JSONObject> 대신 datas패키지에 만든 새로만든 클래스 <BasicResponse>로 수정
// 이제 Call은 서버의 응답 본문 (body)을, BasicResponse 클래스 형태로 자동 변환됨.
    ) : Call<BasicResponse>

//    회원가입 확인 : PUT-FormData방식이므로 Field 사용
    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email") email: String,
        @Field("password") pw: String,
        @Field("nick_name") nick: String,
    ) : Call<BasicResponse>

//    이메일 중복 확인 : GET-query방식이므로 그냥 get 사용
    @GET("/user/check")
    fun getRequestDuplicatedCheck(
        @Query("type") type: String,
        @Query("value") value: String,
    ) : Call<BasicResponse>

//    내 정보 조회
    @GET("/user")
    fun getRequestMyInfo(
        @Header("X-Http-Token") token: String,
    ) : Call<BasicResponse>

//    자동으로 토큰을 불러모는 세팅.(API 호출
    @GET("/uer/friend")
    fun getRequestFriendList(
//        @Header("X-Http-Token") token: String,
        @Query("type") type: String,
    ) : Call<BasicResponse>

}