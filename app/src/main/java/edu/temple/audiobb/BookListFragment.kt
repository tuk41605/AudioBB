package edu.temple.audiobb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookListFragment() : Fragment() {

    lateinit var bookList: BookList
    lateinit var v: View
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            bookList = it.getSerializable("bookList") as BookList
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.booklist_fragment, container, false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = v.findViewById(R.id.booklist_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = CustomAdapter(requireContext(), bookList) {
            updateViewModel(recyclerView.getChildAdapterPosition(it))
        }
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: BookList): BookListFragment {
            val bookListFragment = BookListFragment().apply {
                bookList = param1
                arguments = Bundle().apply {
                    putSerializable("bookList", bookList)
                }
            }

            return bookListFragment
        }
    }

    private fun updateViewModel(index: Int) {
        ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            .setSelectedBook(bookList.get(index))
        (requireActivity() as DoubleLayout).selectionMade()
    }

    interface DoubleLayout {
        fun selectionMade()
    }
}