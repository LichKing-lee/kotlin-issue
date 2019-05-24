package com.yong.cglib.before

data class NaverParam(private val apiId: Int,
                      private val naverId: Int) {
    fun toParam() = "$naverId,$apiId"
}