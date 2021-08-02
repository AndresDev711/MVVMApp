package com.andredev.simpleapp.data

import com.andredev.simpleapp.data.model.QuoteModel
import com.andredev.simpleapp.data.model.QuoteProvider
import com.andredev.simpleapp.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:  QuoteService,
    private val quoteProvider: QuoteProvider
){

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }

}