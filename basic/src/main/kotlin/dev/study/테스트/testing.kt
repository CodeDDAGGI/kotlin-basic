package dev.study.테스트

fun main(){
//    var add: Int = 10;
//    var df = if (add > 20) "ok" else "No"
//
//    if (df == "ok") println("1") else "No"
//
//    var ads:Int = 0;

    val testi = testing("홍길동" , 25)
    println(testing("길동이" , 60))
    println(testi.add("길동" , 5))

}

data class testing (
    val a : String,
    val b : Int
){
    fun add (a : String , b: Int) : String{
        return "$a + $b"
    }


}



