package com.study.비동기

import kotlinx.coroutines.flow.callbackFlow
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

// 점원이 3명
private val executor = Executors.newFixedThreadPool(3) // n 개의 쓰레드를 만들겠다

// 쓰레드풀에도 여러종류가있어서 알아보는게 좋음
//private val executor2 = Executors.

fun grindBeanAsync(
    beanType: String,
    callback : (String) -> Unit // 어떤 타입이 들어올지 모르기 때문에
){
    executor.submit{
        Thread.sleep(1000)
        callback("갈린 $beanType 원두")
    }
}

fun brewCoffeeAsync (
    ground : String,
    callback: (String) -> Unit
){
    executor.submit{
        Thread.sleep(1000)
        callback("${ground}으로 만든 커피")
    }
}

fun pourInCupAsync (
    coffee : String,
    callback: (String) -> Unit
){
    executor.submit{
        Thread.sleep(1000)
        callback("[cup] $coffee")
    }
}

fun grindBeansFuture(beanType: String):CompletableFuture<String> =
    CompletableFuture.supplyAsync({
        Thread.sleep(1000)
        "갈린 $beanType 원두"
    }, executor)

fun brewCoffeeFuture(groundBeans: String):CompletableFuture<String> =
        CompletableFuture.supplyAsync({
            // 동기?
            Thread.sleep(1000)
            "${groundBeans}으로 만든 커피"
        }, executor)
fun pourInCupAsync (coffee : String) : CompletableFuture<String> =
    CompletableFuture.supplyAsync({
        Thread.sleep(1000)
        "[cup] : $coffee"
    }, executor)

fun main() {
    val orders = listOf("주문1" , "주문2" , "주문3","주문4" , "주문5" , "주문6", "주문7", "주문8", "주문9" , "주문10")
    val startTime = System.currentTimeMillis()

    // 동기에 가까운 비동기
    val futures = orders.map {
        order -> grindBeansFuture(order)
            .thenCompose { brewCoffeeFuture(it) }
            .thenCompose { pourInCupAsync(it) }
            .thenApply { result -> "[$order] $result" }
    }

    futures.forEach{ println(it.get()) }
    executor.shutdown()
    println("총 소요시간 : ${System.currentTimeMillis() - startTime}")
}


//fun main() {
//    val startTime = System.currentTimeMillis()
//
//    // 콜백 지옥 EX) 다른커피 제조할때 더 늘어나니까 콜백지옥이 댐
//    // 자바의 옛날 방식 - 쓰지않아서 이런방식이 있구나 라고 생각하면댐
//    grindBeanAsync("콜롬비아"){ ground ->
//        brewCoffeeAsync(ground){ coffee ->
//            pourInCupAsync(coffee){result ->
//                println(result)
//            println("총 소요 시간 : ${System.currentTimeMillis() - startTime}")
//            executor.shutdown()
//            }
//        }
//    }
//    // 비동기 작업이라서 소요시간을 임시대기 방편으로 넣어줌
//    Thread.sleep(4000)
//}