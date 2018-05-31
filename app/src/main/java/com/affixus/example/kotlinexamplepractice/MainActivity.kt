package com.affixus.example.kotlinexamplepractice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit var et_val1 : EditText
    lateinit var et_val2 : EditText
    lateinit var tv_result : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val textView : TextView = findViewById(R.id.tv_hellow_world)

        textView.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, textView.text, Toast.LENGTH_SHORT).show()
        })*/

        et_val1 = findViewById(R.id.et_val1)
        et_val2  = findViewById(R.id.et_val2)
        tv_result  = findViewById(R.id.tv_result)
        //val btn_add : Button = findViewById(R.id.btn_add)

        btn_add.setOnClickListener(View.OnClickListener {
            if (et_val1.text.isEmpty() || et_val2.text.isEmpty()){
                Toast.makeText(this@MainActivity,"empty values not allowed",Toast.LENGTH_SHORT).show()
            }else {
                addValue()
            }
        })

        val btn_open_new_Screen : Button = findViewById(R.id.btn_open_new_Screen)

        btn_open_new_Screen.setOnClickListener {

            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            intent.putExtra("Hello","hello comes from previous activity")
            startActivity(intent)
        }
    }

    private fun addValue() {

        val firstVal : Int = et_val1.text.toString().toInt()
        val  secondVal : Int = et_val2.text.toString().toInt()
        val total = firstVal + secondVal
        tv_result.setText(total.toString())
        tv_result.visibility = View.VISIBLE

    }
}
