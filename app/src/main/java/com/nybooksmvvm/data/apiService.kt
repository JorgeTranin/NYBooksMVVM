package com.nybooksmvvm.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object apiService {
   private fun initRtrofit(): Retrofit{
    return Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/books/v3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    }

    val service = initRtrofit().create(NYServices::class.java)

}