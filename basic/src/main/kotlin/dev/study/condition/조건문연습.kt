package dev.study.condition

fun main() {

    // 변수에도 사용가능
    var na = 15
    var da = 10
    var ife = if(na > da) println("$na 는 $da 보다 크다") else "$na 가 더 작다"

    fun dis (a : Int , b : Int):String{
        return when{
            a > b -> "$a 가 크다"
            a < b -> "$b 가 크다"
            else -> "같다"
        }
    }

    fun dsss (a:Any){
        when(a){
            1 -> println("정수형")
            a -> println("문자열")
        }
    }
    // 순서대로 작성을 안하면
    // 정수형으로 도달하지 않아서 동작을 안함
    dsss(1)
    dsss("문자")
    dsss(true)

    var i:Int? = 2
    var name = "김길동"
    var age = 25

    // 순서대로 동작함
//    when(){
//        i -> println(i);
//        name == "김길동" -> println("당신의 $name 입니다")
//        age > 20 -> println("성인입니다")
//    }

}

