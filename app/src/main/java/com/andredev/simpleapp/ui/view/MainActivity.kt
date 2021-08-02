package com.andredev.simpleapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.andredev.simpleapp.databinding.ActivityMainBinding
import com.andredev.simpleapp.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.create()

        quoteViewModel.isLoading.observe(this, Observer { isLoading ->
            binding.loading.isVisible = isLoading
        })

        quoteViewModel.quoteModel.observe(this, Observer { quoteResult ->
            binding.tvQuote.text = quoteResult.quote
            binding.tvAuthor.text = quoteResult.author
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
}