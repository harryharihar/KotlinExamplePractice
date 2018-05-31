package com.affixus.example.kotlinexamplepractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by dipak on 30/05/2018.
 */
class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val data = intent.getStringExtra("Hello")

        val tv_text : TextView = findViewById(R.id.tv_text)
        if (data!=null){
            tv_text.setText(data.toString())
        }

        val rv_data_list : RecyclerView = findViewById(R.id.rv_data_list)
        rv_data_list.layoutManager = LinearLayoutManager(this@SecondActivity ,LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager?

        val userModelList = ArrayList<UserModel>()

        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harry","Belapur"))
        userModelList.add(UserModel("Sunil","Nerul"))
        userModelList.add(UserModel("Sunil Kumar","Kharghar"))
        userModelList.add(UserModel("Shashi","Ambivali"))
        userModelList.add(UserModel("Akhshay","Sanpada"))
        userModelList.add(UserModel("Ajay","Vashi"))
        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harihar","Kharghar"))
        userModelList.add(UserModel("Harihar","Kharghar"))

        val userAdapter = UserAdapter(userModelList,this@SecondActivity)
        rv_data_list.adapter = userAdapter
    }
}