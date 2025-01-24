package dev.study.dataclass

/**
 * data class 와 componion object를 활용하여 문제 해결
 * - 이름과 가격을 가지는 Product 데이터를 나타내는 클래스를 생성
 * - componion object를 사용해서 샘플 데이터를 반환하는 정적 메서드를 작성하세요
 * - 샘플 데이터를 출력해주세요.
 */

//data class Product(
//    var name : String,
//    var price : Int
//){
//    companion object {
//        fun data(name : String ,price : Int) : String = "제품명 : $name , 가격 : $price"
//    }
//}
//
//fun main(){
//    var sampleData = Product.data("청소기" , 50000)
//    println(sampleData)
//}

// 개발자님 답

//data class Product2(
//    var name : String,
//    var price : Double
//){
//    companion object {
//        fun data() = listOf(
//            Product2("Laptop" ,1000.0),
//            Product2("Phone" , 1400.0)
//        )
//    }
//}

data class Product(
    val name: String,
    val price : Double
)

class ProductFactory {
    companion object {
        fun createSampleProducts(): List<Product> {
            return listOf(
                Product("LapTop" , 1500.0),
                Product("Phone", 1500.0)
            )
        }
    }
}

fun main(){
    val createSampleModel():List<Product>{
        return listOf(
            Product("LapTop" , 1500.0),
            Product("Phone", 1500.0)
        )
    }
}