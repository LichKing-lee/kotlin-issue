package com.yong.cglib.after

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

data class Param(val naverParams: List<NaverParam>): Parameterizable {
    override fun toParam(): MultiValueMap<String, String> {
        val map = LinkedMultiValueMap<String, String>()

        map.add("caller", "test")
        map.add("paramList", naverParams.joinToString(separator = ":", transform = NaverParam::toParam))

        return map
    }

    data class NaverParam(val apiId: Int,
                          val naverId: Int) {
        fun toParam() = "$apiId,$naverId"
    }
}