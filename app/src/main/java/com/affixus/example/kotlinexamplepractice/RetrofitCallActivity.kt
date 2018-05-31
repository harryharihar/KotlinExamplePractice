package com.affixus.example.kotlinexamplepractice

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by dipak on 31/05/2018.
 */
class RetrofitCallActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        btnClick.setOnClickListener(View.OnClickListener {
            DisplayProgressDialog()
            callWebService()

        })
    }

    private fun callWebService() {

        val apiService = ApiInterface.create()
        val call = apiService.getCategoryDetails()

        call.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: retrofit2.Response<CategoryResponse>?) {
                if (response != null) {
                    if (pDialog != null && pDialog!!.isShowing()) {
                        pDialog.dismiss()
                    }
                    var list: List<Category> = response.body().categories!!
                    Log.d("RetrofitCallActivity", "" + list.size)
                    var msg: String = ""
                    for (item: Category in list.iterator()) {
                        msg = msg + item.title + "\n"
                    }
                    txtDisplay.setText(msg + "")
                }

            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                //                Log.e(TAG, t.toString());
                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss()
                }
            }
        })
    }

    lateinit var pDialog: ProgressDialog
    private fun DisplayProgressDialog() {

        pDialog = ProgressDialog(this@RetrofitCallActivity)
        pDialog!!.setMessage("Loading..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()
    }
}