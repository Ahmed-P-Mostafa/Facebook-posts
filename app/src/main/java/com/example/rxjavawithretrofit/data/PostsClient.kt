package com.example.rxjavawithretrofit.data

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostsClient {



    companion object{

        private val BASE_URL = "http://jsonplaceholder.typicode.com/"
        private lateinit var postsInterface :PostsInterface
        private lateinit var instance:PostsClient

        private var retrofit :Retrofit?=null


        private fun getRetrofit():Retrofit{
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        fun getInstance():PostsInterface{
           return getRetrofit().create(PostsInterface::class.java)
        }
    }

}