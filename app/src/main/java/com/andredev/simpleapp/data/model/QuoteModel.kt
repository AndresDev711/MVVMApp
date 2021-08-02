package com.andredev.simpleapp.data.model

import com.google.gson.annotations.SerializedName

class QuoteModel(@SerializedName("quote") val  quote: String,@SerializedName("author") val author: String) {
}