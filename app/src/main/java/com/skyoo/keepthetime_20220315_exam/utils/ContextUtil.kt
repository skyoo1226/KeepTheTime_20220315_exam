package com.skyoo.keepthetime_20220315_exam.utils

import android.content.Context

class ContextUtil {
    companion object {
//        일종의 메모장의 파일 이름 "KeepTheTimePref"
        private val prefName = "KeepTheTimePref"

        private val AUTO_LOGIN = "AUTO_LOGIN"
        private val TOKEN = "TOKEN"

        fun setAutoLogin(context: Context, isAutoLogin: Boolean) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            pref.edit().putBoolean(AUTO_LOGIN, isAutoLogin).apply()

        }
//        조회 기능: getter
        fun getAutoLogin( context: Context) : Boolean {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return  pref.getBoolean(AUTO_LOGIN, false)
        }
//        토큰값을 TOKEN에 String값을 저장
        fun setToken( context: Context, token: String) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(TOKEN, token).apply()
        }
//        토큰값 조회, 비어 있을 수 있음. "" 표시
        fun getToken( context: Context ) : String {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getString(TOKEN, "")!!
        }
    }
}