package edu.temple.audiobb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class BookDetailsFragment : Fragment() {
    lateinit var title: TextView
    lateinit var author: TextView
    lateinit var v: View

    // no real functionality implemented in onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.bookdetails_fragment, container, false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = v.findViewById(R.id.fragment_book_details_title)
        author = v.findViewById(R.id.fragment_book_details_author)

        ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            .getBook()
            .observe(viewLifecycleOwner, {
                changeBook()
            })
    }

    private fun changeBook() {
        val selectedBook = ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            .getBook()

        title.text = selectedBook.value?.title
        author.text = selectedBook.value?.author
    }

    companion object {
        @JvmStatic
        fun newInstance() = BookDetailsFragment()
    }
}