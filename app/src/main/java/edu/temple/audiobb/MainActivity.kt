package edu.temple.audiobb

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // test = findViewById(R.layout.activity_main)
        // inflate(R.layout.another_layout, test)

        val bookList= ArrayList<Book>()
        val library = BookList(bookList)
        populateInitialLibrary(library)
        // This code is purely for testing purposes
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, BookDetailsFragment.newInstance("no", "no"))
                .commit()
        if(resources.configuration.orientation == ORIENTATION_LANDSCAPE)
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, BookListFragment.newInstance("no", "no"))
                .commit()
        }
        // END TEST
    }

    private fun populateInitialLibrary(library: BookList)
    {
        library.add(Book("For Whom the Bell Tolls", "Ernest Hemingway"))
        library.add(Book("Bhagavad Gita", "Vyasa"))
        library.add(Book("Iliad", "Homer"))
        library.add(Book("The Histories", "Herodotus"))
        library.add(Book("Dune", "Frank Herbert"))
        library.add(Book("Das Kapital", "Karl Marx"))
        library.add(Book("The Crusades", "Thomas Asbridge"))
        library.add(Book("Irene Iddesleigh", "Amanda McKitrick Ros"))
        library.add(Book("The Art of War", "Sun Tzu"))
        library.add(Book("War and Peace", "Leo Tolstoy"))
        library.add(Book("Wiseguy", "Nocholas Pileggi"))
        library.add(Book("One Flew Over the Cuckoo's Nest", "Ken Kesey"))
        library.add(Book("Into the Wild", "Jon Krakauer"))
        library.add(Book("When Titans Clashed", "David Glantz"))
        library.add(Book("Poetics and Rhetoric", "Aristotle"))
    }
}