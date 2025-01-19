package org.study.dev.study

// 가장 기본적인 함수 선언 스타일
fun add (a :Int , b: Int):Int {
    return a + b
}

// 표현식 스타일
//fun sum2 (a : Int , b: Int):Int = a + b

// 표현식 + 반환 타입 삭제
// 타입 추론을 사용한 경우
//fun sum3 (a : Int , b:Int) = a + b

// 몸통이 있는 함수의 반환 타입은 제거하면 컴파일 오류가 발생
// Unit : default void랑 같은 느낌
// 리턴이 있고 몸통이 있는 경우 Unit이면 안댐
// fun add4(a :Int , b: Int):Unit {
//    return a + b
// }

// 몸통이 있는 함수로 작성시 반환타입으르 정해주지 않으면 반환타입이 없음
//fun add5(a :Int , b: Int) {
//    println("$a + $b")
//}
//
//fun greeting(message : String = "안녕하세요"){
//    println(message)
//}

fun log(level : String = "INFO" , message: String){
    println("{$level} : $message")
}

// 고차 함수
// - 함수를 매개변수로 받거나 반환
// operation함수가 들어온거임
fun calculater(a:Int , b:Int , operation : (Int, Int) -> Int):Int{
    return operation(a, b)
}

fun main(){
//    greeting()
    log(message = "인포 로그")
    log(level = "DEBUG", message = "인포 로그")
    log("DEBUG", "인포 로그")
    log(level = "ERROR", "인포 로그")

    calculater(5, 6,){x , y -> x + y}
    // it 기본 매개변수
//    val square : (Int) -> Int = { it + it }
//    println(square(5))
    // 중괄호가 열리면 람다가 생성된거임
    // 자바의 익명함수랑 비슷한 개념임
//    println(calculater(4, 6) {x , y -> x + y})
}
