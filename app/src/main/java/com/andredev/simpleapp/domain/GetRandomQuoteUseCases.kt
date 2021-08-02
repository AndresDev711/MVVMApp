package com.andredev.simpleapp.domain

import com.andredev.simpleapp.data.model.QuoteModel
import com.andredev.simpleapp.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCases @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke(): QuoteModel?{
        val quote: List<QuoteModel> = quoteProvider.quotes
        if(!quote.isNullOrEmpty()){
            val randomNumber = (0..quote.size - 1).random()
            return quote[randomNumber]
        }
        return null
    }

}