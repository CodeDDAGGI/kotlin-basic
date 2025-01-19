package dev.study.dataclass

/**
 * data class 와 componion object를 활용하여 문제 해결
 * - 이름과 가격을 가지는 Product 데이터를 나타내는 클래스를 생성
 * - componion object를 사용해서 샘플 데이터를 반환하는 정적 메서드를 작성하세요
 * - 샘플 데이터를 출력해주세요.
 */

data class Product(
    var name : String,
    var price : Int
){
    companion object {
        fun data(name : String ,price : Int) : String = "제품명 : $name , 가격 : $price"
    }
}

fun main(){
    var sampleData = Product.data("청소기" , 50000)
    println(sampleData)

}