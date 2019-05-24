package com.yong.cglib.middle

data class NaverParam(private val apiId: Int,
                      private val naverId: Int) {
    fun toParam() = "$apiId,$naverId"
}