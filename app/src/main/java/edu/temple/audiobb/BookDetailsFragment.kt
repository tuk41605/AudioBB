package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class BookDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            .getTitle()
            .observe(requireActivity(), {
                changeTitle(it)
            })

        ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            .getAuthor()
            .observe(requireActivity(), {
                changeAuthor(it)
            })
    }

    private fun changeTitle(title : String) {
        val bTitle = view?.findViewById<TextView>(R.id.fragment_book_details_title)

        if (bTitle != null) {
            bTitle.text = title
        }
    }

    private fun changeAuthor(author : String) {
        val bAuthor = view?.findViewById<TextView>(R.id.fragment_book_details_author)

        if (bAuthor != null) {
            bAuthor.text = author
        }
    }

}