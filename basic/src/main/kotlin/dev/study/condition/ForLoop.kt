package dev.study.condition

fun main() {
    // 범위 연산자 .. 앞과 뒤 숫자를 모두 포함
    // 10과 30을 포함함
//    for(i in 10..30){
//        println(i)
//    }

    // until : 끝 숫자를 미포함
    for(i in 0 until 10){
        println(i)
    }

    // step :
    for(i in 0 until 10 step 2){
        println(i)
    }

    // 역순으로 정렬
    // 처음 수와 끝 수를 포함
    for (i in 10 downTo 0 step 2){
        println(i)
    }

    // 배열 생성
    // Alt 엔터를 변수 생성
    val array = arrayOf(1, 2, 5, 4, 5)
    for(i in array){
        println(i)
    }

    // 배열을 하나씩 꺼내는 방법

    for(i in array.indices){
        array[i]
    }

    // 코틀린에서 옛날 방식
    for((i ,name) in array.withIndex()){
        println("$i , $name")
    }

    // 배열 , 리스트는 주로 람다 방식으로 사용
    array.forEachIndexed { i , name ->
        println("$i , $name")
    }

    // 정적 메소드 패턴
    val 나라 = mapOf(
        "서울" to "한국",
        "동경" to "일본"
    )

    // ${}이용하면 속성의 값을 가져올수 있음
    for(entry in 나라.entries){
        println(
            "${entry.key} , ${entry.value}"
        )
    }

    for((capital , country) in 나라){
        println("$country , $capital")
    }

    나라.forEach { (capital, country) ->
        println("$country , $capital")
    }

//    listOf()

}

