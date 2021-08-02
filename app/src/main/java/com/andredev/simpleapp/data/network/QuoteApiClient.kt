package com.andredev.simpleapp.data.network

import com.andredev.simpleapp.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>

}