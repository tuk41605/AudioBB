package edu.temple.audiobb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// TODO: THIS CLASS NEEDS TO BE IMPLEMENTED
private val ARG_PARAM1 = BookList(ArrayList<Book>())

/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment() {
    private lateinit var list: BookList(ArrayList<Book>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // aaaa
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putStringArray(ARG_PARAM1, param1)
                }
            }
    }
}