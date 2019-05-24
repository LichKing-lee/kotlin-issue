package com.yong.cglib.after

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.util.LinkedMultiValueMap

@Repository("afterNaverApiRepository")
@ConfigurationProperties("naver")
class NaverApiRepository: TemplateApiRepository() {

}