package com.yong.cglib.before

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Repository
import org.springframework.util.LinkedMultiValueMap

@Repository
@ConfigurationProperties("naver")
class NaverApiRepository: BaseApiRepository() {
    fun call(params: List<NaverParam>) {
        val paramList = params.joinToString(separator = ":", transform = NaverParam::toParam)

        val map = LinkedMultiValueMap<String, String>()
        map.add("paramList", paramList)
        map.add("caller", "test")

        val url = buildUrl(map)

        restTemplate?.getForObject(url, String::class.java)
    }
}