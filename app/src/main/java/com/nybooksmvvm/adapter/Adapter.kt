package com.nybooksmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nybooksmvvm.data.model.Book
import com.nybooksmvvm.databinding.ItemBookBinding

class BooksAdapter(private val context: Context,
    //estou dizendo que eu espero uma lista de Book, classe criada para o modelo de Book
   private val books: List<Book>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

// cria o item da lista para o onbind
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemLista = ItemBookBinding.inflate(LayoutInflater.from(context), parent, false)
        return BooksViewHolder(itemLista)
    }

    // retorna a quantidade de itens que tem na lista
    override fun getItemCount() = books.count()


// faz a ligação de cada item da lista com o componente de recyclerview
    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }


    class BooksViewHolder(binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root){
        private val title = binding.txtTituloLivro
        private val author = binding.txtAutorLivro
        fun bindView( book:  Book){
            title.text = book.title
            author.text = book.author
        }
    }
}