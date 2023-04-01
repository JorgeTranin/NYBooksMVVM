package com.nybooksmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nybooksmvvm.R
import com.nybooksmvvm.ViewModel.BooksViewModel
import com.nybooksmvvm.adapter.BooksAdapter
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


// Inicializa uma instância do ViewModel BooksViewModel usando a ViewModelProvider API

        val viewModel: BooksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)


        viewModel.booksLiveData.observe(this, Observer { // adiciona um observer à propriedade booksLiveData do ViewModel viewModel para
            // observar mudanças em seu valor. O this passado como parâmetro indica o ciclo de vida do observador, que será destruído quando a atividade
            // ou fragmento associado a ele for destruído.

            it?.let {  books -> // verifica se it, que é o valor atual de booksLiveData, não é nulo. Se não for nulo, executa o bloco de código dentro do let.

                with(binding.recyclerViewBooks){ // inicia um escopo with com o objeto binding.recyclerViewBooks como receptor.
                    // Isso permite acessar suas propriedades e métodos sem repetir seu nome.


                    // define o gerenciador de layout da RecyclerView como um LinearLayoutManager vertical, que organiza os itens em uma coluna única.
                    // O primeiro parâmetro this@BooksActivity indica o contexto do layout manager.
                    layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)

                    setHasFixedSize(true) // indica que o tamanho da RecyclerView não será alterado durante o tempo de execução.
                    // Isso pode melhorar o desempenho, pois permite que a RecyclerView otimize a exibição dos itens.

                    adapter = BooksAdapter(this@BooksActivity,books) // define o adaptador da RecyclerView como uma instância de BooksAdapter,
                // que recebe this@BooksActivity como contexto e books como dados a serem exibidos.
                }

            }
        })


        viewModel.getBooks()



    }




}