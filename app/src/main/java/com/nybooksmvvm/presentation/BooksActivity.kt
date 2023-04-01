package com.nybooksmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nybooksmvvm.R
import com.nybooksmvvm.adapter.BooksAdapter
import com.nybooksmvvm.data.model.Book
import com.nybooksmvvm.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set de uma string que está no arquivo string na Toobar
        binding.toolbarMain.title = getString(R.string.books_title)
        setSupportActionBar(binding.toolbarMain)

// Usando o with para acessar dentro da minha recylcer View, para não precisar acessar separadamente cada item
        with(binding.recyclerViewBooks){

            layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)

            //Dizendo que minha lista é fixa
            setHasFixedSize(true)

            adapter = BooksAdapter(this@BooksActivity,getBooks())
        }
    }

// função com lista de livros para testes
    fun getBooks(): List<Book>{
        return listOf(
            Book("Titulo 1", " author 1"),
            Book("Titulo 2", " author 2"),
            Book("Titulo 3", " author 3"),
            Book("Titulo 4", " author 4")
        )
    }


}