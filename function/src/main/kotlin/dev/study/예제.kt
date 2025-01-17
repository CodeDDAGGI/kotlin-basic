package org.study.dev.study

// 코틀린 람다, 스트림을 주로 사용함
fun sum(a:Int , b:Int) : Int {
    var sum = 0;
    for(i in a..b){
        sum += i
    }
    return sum
}
// 같은 패키지내 함수는 존재할수가 없음

fun product(a:Int , b:Int) : Int {
    var product = 0;
    for(i in a..b){
        product += i
    }
    return product
}

// 중괄호가 열리면 람다가 열림
fun sum2(a:Int , b: Int) = fold(a, b,0, {acc,i -> acc + i})

fun fold (
    a: Int,
    b: Int,
    initial : Int,
    //자바의 Function
    // 펑셔널인터페이스도 람다
    operation:(Int, Int) -> Int
): Int {
    var acc = initial
    for (i in a..b) {
        acc = operation(acc, i)
    }
    return acc
}

// 조금 더 업그레이드
// 위의 fold와 밑의 함수와는 다른 함수임
fun sum3(a: Int , b: Int) =(a..b).fold(0){ acc,i -> acc + i }

fun sum4(a:Int , b:Int) = (a..b).fold(0, Int::plus)

// 컬렉션 함수 참조 방식으로 변경
fun sum5(a:Int , b:Int) = (a..b).sum()