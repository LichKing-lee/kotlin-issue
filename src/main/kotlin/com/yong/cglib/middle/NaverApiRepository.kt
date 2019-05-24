package com.yong.cglib.middle

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Repository
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@Repository("middleNaverApiRepository")
@ConfigurationProperties("naver")
class NaverApiRepository : BaseApiRepository<List<NaverParam>>() {
    override fun buildParam(t: List<NaverParam>): MultiValueMap<String, String> {
        val paramList = t.joinToString(separator = ":", transform = NaverParam::toParam)

        val map = LinkedMultiValueMap<String, String>()
        map.add("paramList", paramList)
        map.add("caller", "test")

        return map
    }
}