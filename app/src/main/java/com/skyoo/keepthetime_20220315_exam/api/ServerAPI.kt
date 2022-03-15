package com.skyoo.keepthetime_20220315_exam.api

import retrofit2.Retrofit

class ServerAPI {

    companion object {

        private var retrofit : Retrofit? = null

        fun getRetrofit() : Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .build()
            }
            return retrofit!!
        }

    }
}