package com.study.코루틴

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

data class User(val id: Int, val name : String)
data class Post(val userId:Int , val content:String)
data class UserWithPosts(val user:User , val posts:List<Post>)

//가짜 api 호출 함수
suspend fun getUser():User{
    delay(1000) // 1초 지연
    return User(1, "Kotlin Admin")
}

suspend fun getPosts(): List<Post> {
    delay(1000)
    return listOf(
        Post(1 , "코루틴 강의 노트"),
        Post(1, "동시성 프로그래밍 정리")
    )
}

suspend fun fetchData() = coroutineScope {
    // 동시에 1초 정도 걸린다 생각하면댐
    // user실행 후 post가 실행되서
    val user = async { getUser() }
    val posts = async { getPosts() }
    UserWithPosts(user.await() , posts.await())
}

fun main() = runBlocking {
    val fatchTime = measureTimeMillis {
        val result = fetchData()
        println("""
            [사용자 데이터 조회 결과]
            사용자 : ${result.user.name}
            게시물 수 : ${result.posts.size}
            첫 게시물 : ${result.posts.first().content}
        """.trimIndent())
    }
    println("데이터 조회 시간 : ${fatchTime}ms \n")
}

