package com.yong.cglib.middle

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.time.Duration
import javax.annotation.PostConstruct

abstract class BaseApiRepository<T>(private var url: String? = null,
                                    private var restTemplate: RestTemplate? = null) {
    @PostConstruct
    fun init() {
        this.restTemplate = RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(300))
                .setReadTimeout(Duration.ofMillis(1000))
                .build()
    }

    fun call(param: T) {
        val url = buildUrl(buildParam(param))

        restTemplate!!.getForObject(url, Map::class.java)
    }

    protected abstract fun buildParam(t: T): MultiValueMap<String, String>

    fun setUrl(url: String) {
        this.url = url
    }

    private fun buildUrl(map: MultiValueMap<String, String>): String = UriComponentsBuilder.fromUriString(url!!)
            .queryParams(map)
            .build()
            .toUriString()
}