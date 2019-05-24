package com.yong.cglib.after

import org.springframework.util.MultiValueMap

interface Parameterizable {
    fun toParam(): MultiValueMap<String, String>
}