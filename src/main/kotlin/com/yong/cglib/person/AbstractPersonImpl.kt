package com.yong.cglib.person

abstract class AbstractPersonImpl(var age: Int? = null,
                                  var name: String? = null): PersonInterface {
    fun init() {
        this.age = 31
        this.name = "LichKing"
    }

    override fun introduce(): String = "age: $age name: $name"
}