package com.andredev.simpleapp.domain

import com.andredev.simpleapp.data.QuoteRepository
import com.andredev.simpleapp.data.model.QuoteModel

class GetQuotesCaseUses {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> =  repository.getAllQuotes()

}