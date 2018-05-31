package com.affixus.example.kotlinexamplepractice

import com.google.gson.annotations.SerializedName

/**
 * Created by dipak on 31/05/2018.
 */
class CategoryResponse {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("categories")
    var categories: ArrayList<Category>? = null

}