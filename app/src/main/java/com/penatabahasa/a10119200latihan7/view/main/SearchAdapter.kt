package com.penatabahasa.a10119200latihan7.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.penatabahasa.a10119200latihan7.databinding.ItemRowUserBinding
import com.penatabahasa.a10119200latihan7.model.response.GithubUser

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class SearchAdapter(private val listUser: List<GithubUser>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    private fun ImageView.loadImage(url: String?) {
        Glide.with(this.context)
            .load(url)
            .circleCrop()
            .into(this)
    }

    class ViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = listUser[position]

        with(holder.binding) {
            imgUserAvatar.loadImage(user.avatarUrl)
            tvName.text = user.login
            tvUrl.text = user.htmlUrl
            root.setOnClickListener { onItemClickCallback.onItemClicked(listUser[position]) }
        }
    }

    override fun getItemCount(): Int = listUser.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }
}