package com.skyoo.keepthetime_20220315_exam.api

import android.content.Context
import com.skyoo.keepthetime_20220315_exam.utils.ContextUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {

    companion object {

        private var retrofit : Retrofit? = null
        private val BASE_URL = "https://keepthetime.xyz"

        fun getRetrofit( context: Context ) : Retrofit {
            if (retrofit == null) {
//  retrofit 객체 생성 시, 추가 세팅을 해서 생성. 모든 API호출이 있을때, 자동으로 토큰을 첨부하도록 함.
//  retrofit 변수를 통해서 API통신을 시작하기 직전에, Request 정보를 먼저 가로채어,
//  가로챈 Request 정보에서, 무조건 헤더에 토큰을 첨부해두고 나서, 그 뒤로 나머지 작업을 이어가도록.
                val interceptor = Interceptor {
                    with(it) {
                        val newRequest = request().newBuilder()
                            .addHeader("X-Http-Token", ContextUtil.getToken(context))
                            .build()
                        proceed(newRequest)
                    }
                }

                val myClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create() )
                    .client(myClient)
                    .build()
            }
            return retrofit!!
        }

    }
}