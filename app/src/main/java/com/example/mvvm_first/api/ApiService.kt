package com.example.mvvm_first.api

import com.example.mvvm_first.helper.Constants
import com.example.mvvm_first.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.EDN_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>

}