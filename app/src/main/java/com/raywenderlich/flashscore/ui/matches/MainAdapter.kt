package com.raywenderlich.flashscore.ui.matches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.flashscore.databinding.ChildRecyclerviewBinding
import com.raywenderlich.flashscore.models.Summary

class MainAdapter:RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var data: List<Summary> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(ChildRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(private var binding: ChildRecyclerviewBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(){


                var leftAdapter = LeftAdapter(data[adapterPosition])
                var rightAdapter = RightAdapter(data[adapterPosition])

                binding.leftRecyclerview.layoutManager = LinearLayoutManager(itemView.context)
                binding.leftRecyclerview.adapter = leftAdapter
                binding.rightRecyclerview.layoutManager = LinearLayoutManager(itemView.context)
                binding.rightRecyclerview.adapter = rightAdapter


        }
    }



}