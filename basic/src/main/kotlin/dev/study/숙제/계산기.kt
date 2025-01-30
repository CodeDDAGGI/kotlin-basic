package dev.study.숙제

/**
 * 클래스 Calculator를 만들고 덧셈, 뺄셈, 곱셈, 나눗셈 메서드를 만들고,
 * 각 메서드가 호출될 때 결과를 출력하시면 됩니다.
 * 단, 함수 형태는 고차함수로 대체 할 수 있으면 좋겠습니다.
 */

//class Calculator{
//    fun calfun (a:Int , b:Int , operation: (Int , Int) -> Int):Int {
//        return operation(a, b)
//    }
//
//    fun add (a: Int , b:Int): Int{
//        return calfun(a, b){x, y -> x + y}
//    }
//
//    fun sub (a: Int , b: Int) : Int{
//        return calfun(a, b){x , y-> x - y}
//    }
//
//    fun multi (a : Int , b: Int) : Int {
//        return calfun(a, b) { x, y -> x * y}
//    }
//
//    fun div ( a: Int , b:Int): Int {
//        return calfun(a, b) { x, y -> x / y}
//    }
//
//}
//
//
//fun main() {
//    var cal = Calculator()
//    println(cal.add(5, 4))
//    println(cal.calfun(5, 4){x , y -> x + y})
//    println(cal.sub(10, 4))
//    println(cal.multi(10 , 20))
//    println(cal.div(5, 20))
//}
//
//class Calculator2{
//    fun add(a:Int , b:Int) = a + b
//    fun sub(a:Int , b:Int) = a - b
//    fun multiply(a:Int , b:Int) = a * b
//    fun div(a:Int , b:Int):Double = a /b.toDouble()
//}



class Calculator {
    fun add(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a - b
    fun multiply(a: Int, b: Int) = a * b
    fun divide(a: Int, b: Int): Double = a / b.toDouble()
}

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int) = operation(a,b)

fun main() {
    println(calculate(10, 5) { x, y -> x + y})
}