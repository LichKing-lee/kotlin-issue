package com.yong.cglib.person

abstract class AbstractPerson(var age: Int? = null,
                              var name: String? = null) {
    fun init() {
        this.age = 31
        this.name = "LichKing"
    }

    fun introduce(): String = "age: $age name: $name"
}