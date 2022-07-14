package com.penatabahasa.a10119200latihan7.view.details.follows

import android.view.LayoutInflater
import android.view.ViewGroup
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

class FollowsAdapter(private val listFollow: List<GithubUser>) :
    RecyclerView.Adapter<FollowsAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val follow = listFollow[position]

        with(holder.binding) {
            Glide.with(root.context)
                .load(follow.avatarUrl)
                .circleCrop()
                .into(imgUserAvatar)
            tvName.text = follow.login
            tvUrl.text = follow.htmlUrl
        }
    }

    override fun getItemCount(): Int = listFollow.size
}