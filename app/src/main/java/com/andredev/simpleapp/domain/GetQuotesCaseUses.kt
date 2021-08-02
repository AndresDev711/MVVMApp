package com.andredev.simpleapp.domain

import com.andredev.simpleapp.data.QuoteRepository
import com.andredev.simpleapp.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesCaseUses @Inject constructor(
    private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<QuoteModel> =  repository.getAllQuotes()

}