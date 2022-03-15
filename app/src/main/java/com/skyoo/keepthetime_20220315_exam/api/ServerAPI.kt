package com.skyoo.keepthetime_20220315_exam.api

import retrofit2.Retrofit

class ServerAPI {

    companion object {

        private var retrofit : Retrofit? = null
        private val BASE_URL = "https://keepthetime.xyz"

        fun getRetrofit() : Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory()
                    .build( GsonConverterFactory.create() )
            }
            return retrofit!!
        }

    }
}