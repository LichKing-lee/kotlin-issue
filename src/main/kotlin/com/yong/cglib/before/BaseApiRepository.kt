package com.yong.cglib.before

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.time.Duration
import javax.annotation.PostConstruct

abstract class BaseApiRepository(private var url: String? = null,
                                 protected var restTemplate: RestTemplate? = null) {
    @PostConstruct
    fun init() {
        this.restTemplate = RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(300))
                .setReadTimeout(Duration.ofMillis(1000))
                .build()
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun buildUrl(map: MultiValueMap<String, String>): String = UriComponentsBuilder.fromUriString(url!!)
            .queryParams(map)
            .build()
            .toUriString()
}