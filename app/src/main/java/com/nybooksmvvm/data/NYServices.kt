package com.nybooksmvvm.data

import retrofit2.Call
import retrofit2.http.GET

interface NYServices {
    @GET("lists.jason")
    fun listRepos (): Call<List<>>
    //Call<List<Repo>> listRepos(@Path("user") String user);

}