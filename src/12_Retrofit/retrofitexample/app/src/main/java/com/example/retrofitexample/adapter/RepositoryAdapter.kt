package com.example.retrofitexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample.R
import com.example.retrofitexample.models.RepositoryResponse
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    private val listRepository = ArrayList<RepositoryResponse>();

    fun setList(listRepository: List<RepositoryResponse>) {
        this.listRepository.clear()
        this.listRepository.addAll(listRepository)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listRepository[position])
    }

    override fun getItemCount(): Int = listRepository.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RepositoryResponse) {
            with(itemView) {
                Glide.with(itemView)
                    .load(item.owner.avatar)
                    .into(img_repository_avatar)

                tv_repository_name.text = item.fullName
                tv_repository_url.text = item.htmlUrl
            }
        }
    }
}