package edu.temple.audiobb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(context: Context, bookList: BookList, listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter.RecyclerViewHolder>()
{
    private val context = context
    private val bookList = bookList
    private val rlistener = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.booklist_recyclerview_info, null)
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val title = holder.rItemView.findViewById<TextView>(R.id.fragment_book_details_title)
        val author = holder.rItemView.findViewById<TextView>(R.id.fragment_book_details_author)

        title.text = bookList.get(position).title
        author.text = bookList.get(position).author

        holder.rItemView.setOnClickListener(rlistener)
    }

    override fun getItemCount() = bookList.size()

    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rItemView = itemView
    }
}