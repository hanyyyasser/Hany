package com.example.myapplication24.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication24.R
import com.example.myapplication24.data.Babysitter
import com.example.myapplication24.data.BabysitterAdapter

class BabysitterAdapter(private val babysitters: List<Babysitter>) : RecyclerView.Adapter<BabysitterAdapter.BabysitterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BabysitterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
        return BabysitterViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return babysitters.size
    }

    override fun onBindViewHolder(holder: BabysitterViewHolder, position: Int) {
        val currentItem = babysitters[position]
        holder.imageView.setImageResource(currentItem.profileImageResId)
        holder.nameView.text = currentItem.name
        holder.priceView.text = currentItem.price.toString()
    }
class BabysitterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView : ImageView = itemView.findViewById(R.id.img)
    val nameView : TextView = itemView.findViewById(R.id.nameTxt)
    val priceView : TextView = itemView.findViewById(R.id.costTxt)
}


}
