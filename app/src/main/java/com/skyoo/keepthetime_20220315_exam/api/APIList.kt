package com.skyoo.keepthetime_20220315_exam.api

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIList {
    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(
        @Field("email") id: String,
        @Field("password") pw: String,
    ) : Call<JSONObject>
}