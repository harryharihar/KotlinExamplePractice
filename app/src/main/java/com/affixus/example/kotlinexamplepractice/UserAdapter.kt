package com.affixus.example.kotlinexamplepractice

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * Created by dipak on 30/05/2018.
 */

class UserAdapter(val userList: ArrayList<UserModel>, val context: SecondActivity) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position], context)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(v)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: UserModel, context: Context) {
            val tv_user_name : TextView = itemView.findViewById(R.id.tv_user_name)
            val tv_user_address : TextView = itemView.findViewById(R.id.tv_user_address)
            val  cv_user : CardView = itemView.findViewById(R.id.cv_user)
            tv_user_name.text = user.name
            tv_user_address.text = user.address
            cv_user.setTag(user)

            cv_user.setOnClickListener(View.OnClickListener {
                val user : UserModel = cv_user.getTag() as UserModel
                Toast.makeText(context,user.name,Toast.LENGTH_SHORT).show()
                val intent = Intent(context,RetrofitCallActivity::class.java)
                context.startActivity(intent)

            })


        }
    }
}