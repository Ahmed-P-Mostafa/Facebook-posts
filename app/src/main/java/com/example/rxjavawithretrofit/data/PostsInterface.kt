package com.example.rxjavawithretrofit.data

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET




interface PostsInterface {
    @GET("posts")
    fun getPosts(): Single<List<PostModel>>
}