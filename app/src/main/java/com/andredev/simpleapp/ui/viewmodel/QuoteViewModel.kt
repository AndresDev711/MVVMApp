package com.andredev.simpleapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andredev.simpleapp.data.model.QuoteModel
import com.andredev.simpleapp.data.model.QuoteProvider
import com.andredev.simpleapp.domain.GetQuotesCaseUses
import com.andredev.simpleapp.domain.GetRandomQuoteUseCases
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel(){
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesCaseUses = GetQuotesCaseUses()
    var getRandomQuoteUseCases = GetRandomQuoteUseCases()

    fun create() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel> = getQuotesCaseUses()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote:QuoteModel? = getRandomQuoteUseCases()

        if(quote != null){
            quoteModel.postValue(quote!!)
            isLoading.postValue(false)
        }
    }

}