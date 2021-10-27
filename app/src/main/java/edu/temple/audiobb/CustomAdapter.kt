package edu.temple.audiobb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val itemList: List<Book>,
                   private val listener: ClickListener) :
    RecyclerView.Adapter<CustomAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_info, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currItem = itemList[position]
        holder.bookTitleView.text = currItem.getBookTitle()
        holder.bookAuthorView.text = currItem.getBookAuthor()
    }

    override fun getItemCount() = itemList.size

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val bookTitleView: TextView = itemView.findViewById(R.id.book_title_textview)
        val bookAuthorView: TextView = itemView.findViewById(R.id.book_author_textview)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val retrieved = itemList[this.adapterPosition]
            listener.onClick(retrieved)
        }
    }

    interface ClickListener {
        fun onClick(retrieved: Book)
    }
}