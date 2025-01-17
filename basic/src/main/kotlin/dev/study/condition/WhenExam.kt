package dev.study.condition

fun main() {

    val day = 2

    // 자바에서는 default 코틀린에서는 else가 있어야댐
    // when 대신 switch를 사용함
    val result = when(day){
            1 , 2 , 4 -> "월요일"
            3 -> "수요일"
            4 -> "목요일"
            5 -> "금요일"
            6 -> "토요일"
            7 -> "일요일"
        else -> "요일을 잘 못 입력하셨습니다"
    }


    println(result)

}