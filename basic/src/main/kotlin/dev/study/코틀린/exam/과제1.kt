package dev.study.코틀린.exam

/**
 * 1.1 변수 선언과 타입추론
 *  val 과 var를 사용해서 이름, 나이 , 직업을 나타내는 변수를 선언하세요
 *  직업 변수를 변경하고, 변경된 값을 출력하세요
 *  타입을 명시적으로 선언한 변수와 타입 추론을 사용한 변수를 각각 하나씩 작성해주세요
 *
 *  예상 출력 :
 *  이름 : Alice, 나이: 25, 직업: 디자이너
 *  변경된 직업 : 개발자
 */

/**
 * 1.2 Nullable 타입과 Null Safety
 * - nullable 타입 변수 name 과 age를 선언해주세요
 * - name 과 age의 값을 출력하되, 값이 없을경우 "Unknown"과 0을 출력하세요
 */

fun main(){
//    var name : String = "홍길동"
//    var age : Int = 25
//    var job : String = "디자이너"

    val name = "홍길동"
    val age = 25
    var job = "디자이너"
//    println("이름 : $name , 나이 : $age , 직업 : $job");

    job = "개발자"

//    println("변경된 직업 : $job")

    var name2 : String? = null ?: "Unkown"
    var age2 : Int? = null ?: 0

//    println("이름 : $name2 , 나이 : $age2")

    var yourname : (String , Int , String) -> String = {name , age , job ->
        "$name , $age , $job"
    }

//    println(yourname(name, age , job))
}
