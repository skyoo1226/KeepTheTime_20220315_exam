package com.skyoo.keepthetime_20220315_exam.utils

import android.content.Context

class ContextUtil {
    companion object {
//        일종의 메모장의 파일 이름 "KeepTheTimePref"
        private val prefName = "KeepTheTimePref"

        private val AUTO_LOGIN = "AUTO_LOGIN"

        fun setAutoLogin(context: Context, isAutoLogin: Boolean) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            pref.edit().putBoolean(AUTO_LOGIN, isAutoLogin).apply()

        }
//        조회 기능: getter
        fun getAutoLogin( context: Context) : Boolean {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return  pref.getBoolean(AUTO_LOGIN, false)
        }
    }
}