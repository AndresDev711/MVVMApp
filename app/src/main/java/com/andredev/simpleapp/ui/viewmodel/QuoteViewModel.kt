package com.andredev.simpleapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andredev.simpleapp.data.model.QuoteModel
import com.andredev.simpleapp.domain.GetQuotesCaseUses
import com.andredev.simpleapp.domain.GetRandomQuoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesCaseUses:GetQuotesCaseUses,
    private val getRandomQuoteUseCases:GetRandomQuoteUseCases
) : ViewModel(){
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

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