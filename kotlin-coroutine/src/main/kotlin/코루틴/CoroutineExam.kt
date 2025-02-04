package com.study.코루틴

import kotlinx.coroutines.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.system.measureTimeMillis

data class User(val id: Int, val name : String)
data class Post(val userId:Int , val content:String)
data class UserWithPosts(val user:User , val posts:List<Post>)
//private val executor = Executors.newFixedThreadPool(3).asCoroutineDispatcher()
private val executor = Executors.newFixedThreadPool(3)
//가짜 api 호출 함수
// 코루틴
//suspend fun getUser():User{
//    delay(1000) // 1초 지연
//    return User(1, "Kotlin Admin")
//}

//suspend fun getPosts(): List<Post> {
//    delay(1000)
//    return listOf(
//        Post(1 , "코루틴 강의 노트"),
//        Post(1, "동시성 프로그래밍 정리")
//    )
//}
//
//suspend fun fetchData() = coroutineScope {
//    // 동시에 1초 정도 걸린다 생각하면댐
//    // user실행 후 post가 실행되서
//    val user = async { getUser() }
//    val posts = async { getPosts() }
//    UserWithPosts(user.await() , posts.await())
//}
//
//fun main() = runBlocking {
//    val fatchTime = measureTimeMillis {
//        val result = fetchData()
//        println("""
//            [사용자 데이터 조회 결과]
//            사용자 : ${result.user.name}
//            게시물 수 : ${result.posts.size}
//            첫 게시물 : ${result.posts.first().content}
//        """.trimIndent())
//    }
//    println("데이터 조회 시간 : ${fatchTime}ms \n")
//}

// CompletableFuture
//fun getUser():CompletableFuture<User>{
//    return CompletableFuture.supplyAsync {
//        Thread.sleep(1000)
//        User(1, "Kotlin Admin")
//    }
//}
//
//fun getPosts():CompletableFuture<List<Post>>{
//    return CompletableFuture.supplyAsync {
//        Thread.sleep(1000)
//        listOf(
//            Post(1, "코루틴 강의 노트"),
//            Post(2,  "동시성 프로그래밍 정리")
//        )
//    }
//}
//
//fun fetchData():CompletableFuture<UserWithPosts> {
//    val user = getUser()
//    val post = getPosts()
//    return user.thenCombine(post){
//            user,post -> UserWithPosts(user,post)
//    }
//}
//
//
//fun main(){
//    val fatchTime = measureTimeMillis {
//        val result = fetchData().get()
//        println("""
//            [사용자 데이터 조회 결과]
//            사용자 : ${result.user.name}
//            게시물 수 : ${result.posts.size}
//            첫 게시물 : ${result.posts.first().content}
//        """.trimIndent())
//    }
//    println("데이터 조회 시간 : ${fatchTime}ms \n")
//}

// Future
//fun getUser():Future<User>{
//    return executor.submit<User>{
//        Thread.sleep(1000)
//        User(1, "Kotlin Admin")
//    }
//}
//
//fun getPost():Future<List<Post>>{
//    return executor.submit<List<Post>>{
//        Thread.sleep(1000)
//        listOf(
//            Post(1, "코루틴 강의 노트"),
//            Post(2, "동시성 프로그래밍 정리")
//        )
//    }
//}
//
//fun fetchData():Future<UserWithPosts>{
//    val user = getUser()
//    val posts = getPost()
//    return executor.submit<UserWithPosts>{
//        UserWithPosts(user.get(), posts.get())
//    }
//}
//
//fun main(){
//    val fatchTime = measureTimeMillis {
//        val result = fetchData().get()
//        println("""
//            [사용자 데이터 조회 결과]
//            사용자 : ${result.user.name}
//            게시물 수 : ${result.posts.size}
//            첫 게시물 : ${result.posts.first().content}
//        """.trimIndent())
//    }
//    println("데이터 조회 시간 : ${fatchTime}ms \n")
//}

// 동기
fun getUser():User{
    Thread.sleep(1000)
    return User(1, "Kotlin Admin")
}

fun getPost():List<Post>{
    Thread.sleep(1000)
    return listOf(
        Post(1, "코틀린 강의 노트"),
        Post(2, "동시성 프로그래밍 정리")
    )
}

fun fetchData():UserWithPosts{
    Thread.sleep(1000)
    val post = getPost()
    val user = getUser()
    return UserWithPosts(user, post)
}

fun main() {
    val start = System.currentTimeMillis()
    val result = fetchData()
        println("""
            [사용자 데이터 조회 결과]
            사용자 : ${result.user.name}
            게시물 수 : ${result.posts.size}
            첫 게시물 : ${result.posts.first().content}
        """.trimIndent())

    println("데이터 조회 시간 : ${System.currentTimeMillis() - start}ms \n")
}