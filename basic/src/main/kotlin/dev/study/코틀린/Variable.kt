package org.study.dev.study.코틀린

/**
   * 변수 선언
 * 1. val (value) -> 값을 변경을 할 수가 없다 (immutable)
 * 2. var(variable) -> 읽기 / 쓰기 모두 가능한 변수(mutable)
 *
 * 자바에서 val 값을 변경을 할 수가 없게하려면 final 불변 변수
 *
 * 타입 추론 (Type inference)
 * 타입을 명시하지 않더라도 타입을 컴파일러가 자동으로 추론한다.
 * java는 명시적으로 타입선언이 필요합니다만 , 자바 10버전 이후에 var 키워드가 생기면서 간소화 가능해졌다.
 *
 * Null Safety, Nullable 타입의 존재합니다.
 *
 */

fun test(){

}

fun main() {
    // 메인클래스가 없어도 실행이 된다
    // 자바는 메인 클래스를 생성해서
    // 명시적 타입 선언
    val name: String = "Kotiln"
    //
    var age = 20

    println("name : $name , Age : $age")
    val message = "Hello, Kotiln"
    val number = 78

    kotlin.io.println("Message : $message, Number: $number")
    // age 변경
    age = 26
    // name = "java"
    println(age)
    println("test");
}
