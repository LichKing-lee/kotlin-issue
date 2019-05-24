package com.yong.cglib

open class Person(private val age: Int? = null) {
    open fun introduce() {
        println("hello world")
    }
}