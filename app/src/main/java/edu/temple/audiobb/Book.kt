package edu.temple.audiobb

class Book (private val title: String, private val author: String)
{
    fun getBookTitle(): String
    {
        return title
    }

    fun getBookAuthor(): String
    {
        return author
    }
}