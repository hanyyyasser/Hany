package com.example.myapplication24.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication24.R
import com.example.myapplication24.data.Babysitter
import com.example.myapplication24.data.BabysitterAdapter
import com.example.myapplication24.databinding.ViewHolderBinding

class BabysitterAdapter (
    private var babysitters: List<Babysitter>
) : RecyclerView.Adapter<BabysitterAdapter.BabysitterViewHolder>() {

    var onUserClick : OnUserClick? = null

    fun updateList(newList: List<Babysitter>) {
        babysitters = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BabysitterViewHolder {
        val binding = ViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BabysitterViewHolder(binding)
    }

    override fun getItemCount(): Int = babysitters.size

    override fun onBindViewHolder(holder: BabysitterViewHolder, position: Int) {
        holder.bind(babysitters[position])
    }

    inner class BabysitterViewHolder(private val binding: ViewHolderBinding)
        : ViewHolder(binding.root) {

            init {
                binding.root.setOnClickListener {
                    onUserClick?.onClick(babysitters[layoutPosition])
                }
            }

            fun bind(babySitter: Babysitter) {
                binding.apply {
                    img.setImageResource(babySitter.profileImageResId)
                    nameTxt.text = babySitter.name
                    costTxt.text = babySitter.price.toString()
                }
            }
    }

    interface OnUserClick {
        fun onClick(babySitter : Babysitter)
    }
}