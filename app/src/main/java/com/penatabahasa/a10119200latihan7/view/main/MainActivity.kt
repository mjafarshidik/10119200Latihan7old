package com.penatabahasa.a10119200latihan7.view.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.penatabahasa.a10119200latihan7.R
import com.penatabahasa.a10119200latihan7.databinding.ActivityMainBinding
import com.penatabahasa.a10119200latihan7.model.response.GithubUser
import com.penatabahasa.a10119200latihan7.utils.Helper
import com.penatabahasa.a10119200latihan7.view.details.UserDetailActivity
import com.penatabahasa.a10119200latihan7.view.favorites.FavoriteUserActivity
import com.penatabahasa.a10119200latihan7.view.settings.ThemeSettingsActivity

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    private val mainViewModel by viewModels<MainViewModel>()
    private var listGithubUser = ArrayList<GithubUser>()
    private val helper = Helper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_10119200Latihan7)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        mainViewModel.listGithubUser.observe(this) { listGithubUser ->
            setUserData(listGithubUser)
        }
        mainViewModel.isLoading.observe(this) {
            helper.showLoading(it, binding!!.progressBar)
        }
        mainViewModel.totalCount.observe(this) {
            showText(it)
        }
        mainViewModel.status.observe(this) { status ->
            status?.let {
                Toast.makeText(this, status.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        val layoutManager = LinearLayoutManager(this@MainActivity)
        binding?.rvUser?.layoutManager = layoutManager

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        binding?.searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchUsername()

        mainViewModel.searchGithubUser(randomStartingList(2))
    }

    private fun randomStartingList(length: Int): String {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"
        return (1..length)
            .map { alphabet.random() }
            .joinToString("")
    }

    private fun searchUsername() {
        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    binding?.rvUser?.visibility = View.VISIBLE
                    mainViewModel.searchGithubUser(it)
                    setUserData(listGithubUser)
                }
                hideKeyboard()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.theme_setting -> {
                val intent = Intent(this@MainActivity, ThemeSettingsActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.favorites -> {
                val intent = Intent(this@MainActivity, FavoriteUserActivity::class.java)
                startActivity(intent)
                true
            }
            else -> true
        }
    }

    private fun setUserData(listGithubUser: List<GithubUser>) {
        val listUser = ArrayList<GithubUser>()
        for (user in listGithubUser) {
            listUser.clear()
            listUser.addAll(listGithubUser)
        }
        val adapter = SearchAdapter(listUser)
        binding?.rvUser?.adapter = adapter

        adapter.setOnItemClickCallback(object : SearchAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(data: GithubUser) {
        val intent = Intent(this@MainActivity, UserDetailActivity::class.java)
        intent.putExtra(UserDetailActivity.EXTRA_USER, data.login)
        startActivity(intent)
    }

    private fun showText(totalCount: Int) {
        binding?.apply {
            if (totalCount == 0) {
                tvNotice.visibility = View.VISIBLE
                tvNotice.text = resources.getString(R.string.user_not_found)
            } else {
                tvNotice.visibility = View.INVISIBLE
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding?.rvUser?.windowToken, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}