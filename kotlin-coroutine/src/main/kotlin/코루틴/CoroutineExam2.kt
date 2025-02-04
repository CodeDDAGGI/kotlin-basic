package com.study.코루틴

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future
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

// 동기

