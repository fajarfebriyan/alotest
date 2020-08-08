package com.example.alodoktermobiletest.homescreen.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.databinding.ListHomeBinding
import com.example.alodoktermobiletest.data.model.ImageCard

class HomeAdapter(private val context: Context?,
                  private val items: ArrayList<ImageCard>,
                  private val listener: OnItemClickListener
): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onClick(model: ImageCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ListHomeBinding = DataBindingUtil.inflate(inflater, R.layout.list_home, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ViewHolder(private val binding: ListHomeBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageCard, listener: OnItemClickListener) {
            item.imageCover?.let { binding.ivCover.setImageResource(it) }

            binding.root.setOnClickListener { view ->
                listener.onClick(item)
            }
        }
    }
}