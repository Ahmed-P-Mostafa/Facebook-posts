package com.example.rxjavawithretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavawithretrofit.data.PostModel
import com.example.rxjavawithretrofit.databinding.PostItemBinding

class PostsAdapter(private var list : List<PostModel>?):RecyclerView.Adapter<PostsAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding :PostItemBinding = DataBindingUtil.inflate(inflater,R.layout.post_item,parent,false)

        return ViewHolder(binding)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list?.get(position)
       holder.bind(item!!)
    }

    override fun getItemCount()= list?.size?:0

    class ViewHolder(private val binding:PostItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(post:PostModel){
            binding.post = post
            binding.invalidateAll()

        }

    }
    fun changeData(list:List<PostModel>){
        this.list = list
        notifyDataSetChanged()

    }
}