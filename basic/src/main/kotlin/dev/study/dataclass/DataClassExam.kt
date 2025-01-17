package dev.study.dataclass

import dev.study.코틀린.널안정성.User

/**
 * java 14 버젼 이후에 나온 개념
 * -> record 클래스의 특징
 * 불변 객체 ->
 *
 * 쓰는 이유
 * 데이터의 안정성
 * 동시성 에러가 나는 일을 줄여줌
 * 최적화에도 좋음
 *
 */

class Test {
    // 클래스와 밀접함
    // 함수
    companion object {
        fun add(a: Int , b : Int) : Int = a + b
    }
}

// data 클래스는 데이터가 무조건 들어가 있어야함
// 필드에 선언해줄때 , 뒤에 붙여줘야댐
data class User(
    val name : String,
    val age : Int,
)

fun main(){
    var user = User("Alice" , 30)
    println(user)
    // .으로 접근 가능함
    println(Test.add(1, 2))
}

