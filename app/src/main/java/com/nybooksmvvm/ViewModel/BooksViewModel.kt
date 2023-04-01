package com.nybooksmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nybooksmvvm.data.model.Book

class BooksViewModel : ViewModel() {
    // ira armazenar os dados da minha lista vinda da api do NY
    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    // função para simular a lista de livro vindo da api

    fun getBooks(){
        // notificação para a actyviti que iremos passar para ela a lista de books
        booksLiveData.value = createdFakeBooks()
    }
    fun createdFakeBooks(): List<Book>{
        return listOf(
            Book("Titulo 1", " author 1"),
            Book("Titulo 2", " author 2"),
            Book("Titulo 3", " author 3"),
            Book("Titulo 4", " author 4")
        )
    }
}