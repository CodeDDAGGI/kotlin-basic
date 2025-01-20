package dev.study.코틀린.널안정성

/**
 * Null Safety
 *
 * 기본적으로 null을 허용 하지않음.
 * ?를 사용해서 Nullable 타입을 명시 가능합니다.
 *
 * Java 모든 참조 타입 변수에 null을 할당가능
 * NPE 에 취약
 * (코틀린 null 안정성에 좋지만 null 오류가 뜰수가 있음)
 *
 * ?.  null 인지 먼저 체크
 * 안전 호출 연산자
 *
 * ?: (엘비스 연산자)
 * !!. 거의 안씀 NPE를 터뜨려야할 경우
 *
 * 코틀린은 삼항연산자가 없음
 */

class User(val name : String){
    fun cheer(){
        println("$name 우리팀 화이팅")
    }
}

var user:User? = null

fun main() {
    val nonNullable: String = "Kotlin" // Non - null 타입
//    val nonNullable1: String = null  오류 Non - null 타입
    var nullable: String ? = null

    //nullable.length  null 허용하려면
    nullable?.length ?: "test"

    // nullable null 일 경우
    nullable?.length ?: -1

    // 변수에 할당이 가능해서 삼항연산자가 필요없음
    val number = if(nonNullable.startsWith("K")) 1 else 2

    println(number)

    println(nullable)
    println(nonNullable)

//    user?.cheer()
//    println(user?.name)
//    user = User("Leona")
//    user?.cheer();
//    println(user?.name)
}