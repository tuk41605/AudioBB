package edu.temple.audiobb

class BookList(private val bookList: ArrayList<Book>)
{
    fun add(book: Book)
    {
        bookList.add(book)
    }

    fun remove(book:Book)
    {
        bookList.remove(book)
    }

    fun get(index: Int): Book
    {
        return bookList[index]
    }

    fun size(): Int
    {
        return bookList.size
    }
}