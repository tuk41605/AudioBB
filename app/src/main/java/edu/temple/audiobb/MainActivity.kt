package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider

/*
    The bulk of this is modified recycled code from the professor's examples in class
 */

class MainActivity : AppCompatActivity(), BookListFragment.DoubleLayout {
    private var twoPanes = false
    lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        twoPanes = findViewById<FragmentContainerView>(R.id.fragmentContainerView2) != null

        if (savedInstanceState == null) {
            bookViewModel.setSelectedBook(Book("", ""))

            if (twoPanes) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView1, BookListFragment.newInstance(populateBooks()))
                    .commit()
            }
            else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView1, BookListFragment.newInstance(populateBooks()))
                    .addToBackStack(null)
                    .commit()
            }
        }

        if (twoPanes) {
            if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) is BookDetailsFragment) {
                supportFragmentManager.popBackStack()
            }

            if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) == null) {

                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerView2, BookDetailsFragment.newInstance())
                    .commit()
            }
        }
        else if (bookViewModel.getBook().value != Book("", "")) {

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView1, BookDetailsFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun selectionMade() {
        if (!twoPanes) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView1, BookDetailsFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun populateBooks(): BookList {
        val list = BookList()
        val titles = resources.getStringArray(R.array.titles)
        val authors = resources.getStringArray(R.array.authors)

        for (i in titles.indices) {
            list.add(Book(titles[i], authors[i]))
        }

        return list
    }
}