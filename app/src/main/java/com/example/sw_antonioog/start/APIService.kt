package com.example.sw_antonioog.start

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getStart(@Url url:String): Response<StartResponser>
}