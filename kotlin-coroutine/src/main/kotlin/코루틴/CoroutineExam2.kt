package com.study.코루틴

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

//fun downloadImage(url:String):String {
//    Thread.sleep(3000)
//
//    return "이미지 데이터 : $url"
//}
//
//fun saveToDisk(image:String){
//    Thread.sleep(2000)
//    println("저장완료 : ${image.take(15)}...")
//}
//
//// 동기 버전
//fun downloadSync(urls: List<String>){
//    urls.forEach { url ->
//        val image = downloadImage(url)
//        saveToDisk(image)
//    }
//}
//
//fun main() {
//    // 이미지 다운로드 테스트
//    val urls = listOf("url1" , "url2" , "url3")
//
//    // 동기 버젼
//    // measureTimeMillis 동기에서도 써도됨
//    val syscTime = measureTimeMillis {
//        downloadSync(urls)
//    }
//    println("동기 다운로드 시간 : ${syscTime}ms")
//}

// CompletableFuture
//private val executor = Executors.newFixedThreadPool(3)
//fun downloadImage(url : String):CompletableFuture<String> =
//    CompletableFuture.supplyAsync({
//        Thread.sleep(1000)
//        "이미지 데이터 : $url"
//    }, executor)
//
//
//fun saveImage(image : String): CompletableFuture<String> =
//    CompletableFuture.supplyAsync({
//        Thread.sleep(1000)
//        "저장 완료 : $image"
//    }, executor)
//
//fun main() {
//    val images = listOf("url1" , "url2" , "url3" )
//    val startTime = System.currentTimeMillis()
//
//    val futures = images.map { imageUrl ->
//        downloadImage(imageUrl)
//            .thenCompose { saveImage(it) }
//            .thenApply { result ->  "$result..."}
//    }
//    futures.forEach{ println(it.get()) }
//    executor.shutdown()
//    println("총 소요시간 : ${System.currentTimeMillis() - startTime}ms \n")
//}

private val executor = Executors.newFixedThreadPool(3)
//// Future
//fun downloadImage(url: String):Future<String>{
//    return executor.submit <String>{
//        Thread.sleep(1000)
//        "저장 완료 : $url"
//    }
//}
//
//fun saveImg(image : String):Future<String> {
//    return executor.submit <String>{
//        Thread.sleep(1000)
//        "이미지 데이터 : $image"
//    }
//}
//
//fun fetchDatad (img:String):Future<String>{
//    val down = downloadImage(img).get()
//
//    return saveImg(down)
//}
//
//fun main() {
//    val images = listOf("url1", "url2", "url3")
//    val start = System.currentTimeMillis()
//
//    val future = images.map { img ->
//        fetchData(img)
//    }
//
//    future.forEach { println(it.get()) }
//
//    executor.shutdown()
//    println("총 소요시간: ${System.currentTimeMillis() - start}ms")
//}

// 코루틴
//suspend fun downloadImage(url: String):String {
//    delay(1000)
//    return "저장완료 : $url"
//}
//
//suspend fun saveImg(img : String):String {
//    delay(1000)
//    return "이미지 데이터: $img"
//}
//
//fun main() = runBlocking{
//    val imgList = listOf("url1" , "url2" , "url3")
//    val start = System.currentTimeMillis()
//    val reload = imgList.map {
//        img -> launch {
//            val image = downloadImage(img)
//            val down = saveImg(image)
//            println(down)
//        }
//    }
//
//    reload.forEach{it.join()}
//
//    println("걸리는 시간 : ${System.currentTimeMillis() - start}ms")
//}

// 개발자님 답
fun downloadImage(url: String): String {
    Thread.sleep(3000)
    return "이미지 데이터: $url"
}

fun saveToDisk(image: String) {
    Thread.sleep(2000)
    println("저장완료: ${image.take(15)}...")
}


fun downloadSync(urls: List<String>) {
    urls.forEach { url ->
        val image = downloadImage(url)
        saveToDisk(image)
    }
}

// 비동기
fun downloadAsync(urls: List<String>) {
    val executor = Executors.newFixedThreadPool(urls.size)

    urls.forEach { url ->
        executor.submit {
            val image = downloadImage(url)
            saveToDisk(image)
        }
    }
}

// 코루틴
suspend fun downloadCoroutine(urls: List<String>) = coroutineScope {
    urls.map { url ->
        async(Dispatchers.IO) {
            val image = downloadImage(url)
            withContext(Dispatchers.Default) {
                saveToDisk(image)
            }
        }
    }.awaitAll()
}

fun main() = runBlocking {
    // 이미지 다운로드 테스트
    val urls = listOf("url1", "url2", "url3")

    // 동기 버전
    val syncTime = measureTimeMillis {
        downloadSync(urls)
    }

    println("동기 다운로드시간: ${syncTime}ms")

    val threadPoolTime = measureTimeMillis {
        downloadAsync(urls)
    }
    println("스레드 풀 비동기 시간: ${threadPoolTime}ms")

    // 코루틴 버전
    val asyncTime = measureTimeMillis {
        downloadCoroutine(urls)
    }
    println("코루틴 다운로드 시간: ${asyncTime}ms")
}
