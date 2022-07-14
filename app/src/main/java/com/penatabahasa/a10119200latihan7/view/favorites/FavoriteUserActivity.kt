package com.penatabahasa.a10119200latihan7.view.favorites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.penatabahasa.a10119200latihan7.R
import com.penatabahasa.a10119200latihan7.databinding.ActivityFavoriteUserBinding
import com.penatabahasa.a10119200latihan7.view.ViewModelFactory

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FavoriteUserActivity : AppCompatActivity() {
    private var _binding: ActivityFavoriteUserBinding? = null
    private val binding get() = _binding
    private lateinit var adapter: FavoriteUserAdapter
    private lateinit var favoriteUserViewModel: FavoriteUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityFavoriteUserBinding.inflate(layoutInflater).also { _binding = it }
        setContentView(binding?.root)
        supportActionBar?.title = getString(R.string.favorite_user)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        favoriteUserViewModel = obtainViewModel(this@FavoriteUserActivity)
        favoriteUserViewModel.getAllFavorites().observe(this) { favoriteList ->
            if (favoriteList != null) {
                adapter.setFavorites(favoriteList)
            }
        }
        adapter = FavoriteUserAdapter()
        binding?.rvFavorites?.layoutManager = LinearLayoutManager(this)
        binding?.rvFavorites?.setHasFixedSize(false)
        binding?.rvFavorites?.adapter = adapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteUserViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[FavoriteUserViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}