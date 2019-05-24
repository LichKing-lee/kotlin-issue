package com.yong.cglib.before

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class NaverApiRepositoryTest {
    @Autowired
    private lateinit var naverApiRepository: NaverApiRepository

    @Test
    fun call() {
        val list = listOf(NaverParam(104585, 769))

        naverApiRepository.call(list)
    }
}