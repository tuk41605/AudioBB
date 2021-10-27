package edu.temple.audiobb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel()
{
    private val title : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val author : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getTitle() : LiveData<String> {
        return title
    }

    fun getAuthor() : LiveData<String> {
        return author
    }

    fun setBookTitle(selectedTitle: String) {
        this.title.value = selectedTitle
    }

    fun setBookAuthor(selectedAuthor: String) {
        this.author.value = selectedAuthor
    }
}