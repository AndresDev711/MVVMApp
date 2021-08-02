package com.andredev.simpleapp.domain

import com.andredev.simpleapp.data.QuoteRepository
import com.andredev.simpleapp.data.model.QuoteModel
import com.andredev.simpleapp.data.model.QuoteProvider

class GetRandomQuoteUseCases {

    operator fun invoke(): QuoteModel?{
        val quote: List<QuoteModel> = QuoteProvider.quotes
        if(!quote.isNullOrEmpty()){
            val randomNumber = (0..quote.size - 1).random()
            return quote[randomNumber]
        }
        return null
    }

}