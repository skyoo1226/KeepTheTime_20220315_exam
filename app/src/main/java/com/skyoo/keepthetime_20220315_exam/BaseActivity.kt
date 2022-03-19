package com.skyoo.keepthetime_20220315_exam

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.skyoo.keepthetime_20220315_exam.api.APIList
import com.skyoo.keepthetime_20220315_exam.api.ServerAPI

// 상속 활용 : 우리화면 >  BaseActivity()  > AppCompatActivity()
// 모든 화면이 공통적으로 사용할 것들 : 여기에서 코딩. 상속을 통해 쉽게 사용 가능.

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: Context
    lateinit var apiList: APIList

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        mContext = this

        val retrofit = ServerAPI.getRetrofit(mContext)
        apiList = retrofit.create(APIList::class.java)
    }
 //    함수 setupEvents / setValues 모든 화면이 (각각 내용이 다르게) 구현.
//    추상 함수(abstract fun) -  실행 내용이 없이 물려주자. => 자식이 상속받은 함수를 반드시 구현하게 의무 부여.
//    클래스 자체도 추상 클래스여야, 추상 함수 보유 가능. 그러므로 윗부분의 class에도 abstract class로 변경.
    abstract fun setupEvens()
    abstract fun setValues()
}