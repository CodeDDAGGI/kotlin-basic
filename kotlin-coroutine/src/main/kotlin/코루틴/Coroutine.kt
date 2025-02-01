package com.study.코루틴

import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.coroutines.Continuation
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

// go언어에서도 존재함 java에만 없고 다른언어에는 왠만하면 있음
// 코루틴으로 바꿔줌
val dispatcher = Executors.newFixedThreadPool(3).asCoroutineDispatcher()

// 코루틴을 사용할땐 함수명을 suspend를 붙여야댐
suspend fun grindBeans(beanType : String): String{
    // 비동기? - Thread.sleep  대신 사용함
    delay(1000)
    return "갈린 $beanType 원두"
}
// suspend 일시 정지 비선점형
suspend fun brewCoffee(ground: String) : String {
    delay(1000)
    return "${ground}으로 만든 커피"
}

suspend fun pourIntoCup(coffee:String) : String{
    delay(1000)
    return "[컵] $coffee"
}

//fun main() = runBlocking {
//    // measureTimeMillis 알아서 끝나는 시점에 시간을 측정해줌
//    val time = measureTimeMillis {
//        val result = async(dispatcher) {
//            val ground = grindBeans("케냐")
//            val coffee = brewCoffee(ground)
//            pourIntoCup(coffee)
//        }
//        println(result.await())
//    }
//    println("총 소요시간 : ${time}ms")
//    (dispatcher.executor as ExecutorService).shutdown()
//}
    //grindBeans("에티오피아") // 콜 자체를 코루틴 안에서 사용해야댐 or 다른 suspend에서
    // 아니면 스코프를 정해줘야댐

// 10를 3초에 값이 나옴
//fun main() = runBlocking {
//    val orders = listOf("주문1" , "주문2" , "주문3","주문4" , "주문5" , "주문6", "주문7", "주문8", "주문9" , "주문10")
//    val time = measureTimeMillis {
//        orders.map { order ->
//            async(dispatcher) { // dispatcher 굳이 안넣어도 상관은 없음
//                val ground = grindBeans(order)
//                val coffee = brewCoffee(ground)
//                val result = pourIntoCup(coffee)
//                "[$order] $result"
//            }
//            // 전체로 걸어줘야댐
//        }.awaitAll().forEach(::println)
//    }
//    println("총 소요시간 : ${time}ms")
//    (dispatcher.executor as ExecutorService).shutdown()
//}

suspend fun doA(){
//    Continuation 알아보기
    val a = 1
    println("start")
    delay(1000)
    println("sum : ${a + 1}")
    println("end")
}

//fun main() = runBlocking { // 코루틴 스코프가 생성이 댐
//    launch { // 새로운 코루틴이 시작이댐
//        // 일단 실행 되지만 delay때문에 hello가 먼저 출력이댐
//        delay(1000)
//        println("World!!")
//    }
//
//    launch(Dispatchers.Default) { /* CPU 집약적인 작업 */  }
//    launch {  } // 위로 같음 default
//    launch(Dispatchers.IO) { /* i/O 작업 */  }
//    launch(Dispatchers.Main) { /* 안드로이드에서 UI 업데이트 */  }
//    launch(Dispatchers.Unconfined){ /* 제한 없음 */ }
//    println("Hello, ")
//}

// 함수를 코루틴에 연결
// 쓰레드 자체를 멈추는 역할 메인에서 사용이댐
// 여러개를 사용하면 실행순서를 알수가 없음
//fun main() = runBlocking { // 최상위 코루틴 함수
//    coroutineScope { // 자식 스코프
//        val job:Job = launch { // 손자 스코프
//               println() // 결과가 없는 작업 Job
//            // 반환형이 없는 건 launch
//        }
//        // launch는 반환형이 없어서 무조건 Job임
//        // 반환형이 있는 건 async
//        val deferred : Deferred<String> =  async{ // 여러 개가 가능
//            delay(1000)
//            "결과물"
//        }
//        println(deferred.await())
//    }
//
//    coroutineScope {
//        launch {
//
//        }
//
//        launch {
//
//        }
//    }
//}

