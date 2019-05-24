package com.yong.cglib.after

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.time.Duration
import javax.annotation.PostConstruct

abstract class TemplateApiRepository(private var url: String? = null,
                                     private var restTemplate: RestTemplate? = null): NaverApiRepositoryInterface {
    @PostConstruct
    fun init() {
        this.restTemplate = RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(300))
                .setReadTimeout(Duration.ofMillis(1000))
                .build()
    }

    override fun call(param: Parameterizable) {
        val url = buildUrl(param.toParam())

        restTemplate!!.getForObject(url, String::class.java)
    }

    fun setUrl(url: String) {
        this.url = url
    }

    private fun buildUrl(map: MultiValueMap<String, String>): String = UriComponentsBuilder.fromUriString(url!!)
            .queryParams(map)
            .build()
            .toUriString()
}