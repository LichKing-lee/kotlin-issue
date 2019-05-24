package com.yong.cglib.person

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.aop.framework.ProxyFactory
import java.lang.reflect.Field
import java.lang.reflect.Method

class PersonTest {
    @Test
    fun implementInterface() {
        val p = PersonImpl()
        p.init()

        val proxyFactory: ProxyFactory = ProxyFactory()

        proxyFactory.setTarget(p)

        val proxy = proxyFactory.proxy as PersonImpl

        println(proxy.javaClass)

        assertThat(proxy.introduce()).isEqualTo("age: 31 name: LichKing")
    }

    @Test
    fun notImplementInterface() {
        val p = Person()
        p.init()

        val proxyFactory: ProxyFactory = ProxyFactory()

        proxyFactory.setTarget(p)

        val proxy = proxyFactory.proxy as Person

        println(proxy.javaClass)

        assertThat(proxy.introduce()).isEqualTo("age: 31 name: LichKing")
    }
}