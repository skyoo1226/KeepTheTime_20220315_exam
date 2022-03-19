package com.skyoo.keepthetime_20220315_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skyoo.keepthetime_20220315_exam.adapters.MyFriendAdapter
import com.skyoo.keepthetime_20220315_exam.databinding.ActivityManageFriendListBinding
import com.skyoo.keepthetime_20220315_exam.datas.BasicResponse
import com.skyoo.keepthetime_20220315_exam.datas.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class ManageFriendListActivity : BaseActivity() {

    lateinit var binding: ActivityManageFriendListBinding
/**
// 내 친구 목록
    val mMyFriendList = ArrayList<UserData>()
    lateinit var mAdapter: MyFriendAdapter
**/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_friend_list)
        setupEvens()
        setValues()
    }

    override fun setupEvens() {

    }

    override fun setValues() {

/**
//  내 친구목록에 서버가 실제 내려주는 친구목록을 채우자(API통신과 결합)
        getMyFriendListFromServer()

        mAdapter = MyFriendAdapter(mContext, R.layout.friend_list_item, mMyFriendList)
        binding.myFriendListView.adapter = mAdapter
**/
    }
/**
    fun getMyFriendListFromServer() {
        apiList.getRequestFriendList(
            type = "my"
        ).enqueue( object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {

                    val br = response.body()!!
                    mMyFriendList.addAll( br.data.friends ) // 서버가 주는 친구목록을 화면 ArrayList에 통째로 추가.

//  리스트뷰의 어댑터 설정보다, 목록에 데이터 추가가 더 늦게 이루어질 수도 있기 때문에...다음 작업 필요.
                    mAdapter.notifyDataSetChanged() //리스트뷰의 내용물을 새로고침.(습관적으로 추가.

                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

    }
**/
}
//   서버가 실제로 내려주는 친구목록을 API 통신을 이용 채운다.
//    fun getMyFriendListFromServer() {
//        apiList.getRequestFriendList("my").enqueue(object : Call<BasicResponse>, response: Respons<BasicResponse>) {
//            if (response) {
//                val br = reponse.body()!!
//                mMyFriendList.addAll(br.data.friends)
//    }
// }
//        override fun onFailure(call: Call<BasicResponse>, t: Throwable) {





