package com.example.myapplication24.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication24.data.model.Order
import com.example.myapplication24.databinding.ViewHolderBinding

class OrdersAdapter (
    private var ordersList : List<Order>
) : RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val binding = ViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrdersViewHolder(binding)
    }

    override fun getItemCount(): Int = ordersList.size

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.bind(ordersList[position])
    }

    inner class OrdersViewHolder(private val binding: ViewHolderBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.apply {
                nameTxt.text = order.name
                costTxt.text = order.cost.toString()
                img.setImageResource(order.image)
            }
        }

    }

}