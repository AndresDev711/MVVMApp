package com.andredev.simpleapp.data

import com.andredev.simpleapp.data.model.QuoteModel
import com.andredev.simpleapp.data.model.QuoteProvider
import com.andredev.simpleapp.data.network.QuoteService

class QuoteRepository {

    private val api =  QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }

}