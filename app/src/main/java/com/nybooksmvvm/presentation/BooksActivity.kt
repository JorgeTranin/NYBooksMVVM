package com.nybooksmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nybooksmvvm.R
import com.nybooksmvvm.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMain.title = "Books"
        setSupportActionBar(binding.toolbarMain)

    }
}