package com.penatabahasa.a10119200latihan7.view.details.follows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.penatabahasa.a10119200latihan7.databinding.FragmentFollowingBinding
import com.penatabahasa.a10119200latihan7.model.response.GithubUser
import com.penatabahasa.a10119200latihan7.utils.Helper
import com.penatabahasa.a10119200latihan7.view.details.UserDetailActivity

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class FollowingFragment : Fragment() {
    private var _binding: FragmentFollowingBinding? = null
    private val binding get() = _binding
    private lateinit var followingViewModel: FollowingViewModel
    private val helper = Helper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        followingViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[FollowingViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followingViewModel.isLoading.observe(viewLifecycleOwner) {
            helper.showLoading(it, binding!!.progressBar3)
        }
        followingViewModel.listFollowing.observe(viewLifecycleOwner) { listFollowing ->
            setDataToFragment(listFollowing)
        }
        followingViewModel.status.observe(viewLifecycleOwner) { status ->
            status?.let {
                Toast.makeText(activity, status.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        followingViewModel.getFollowing(
            arguments?.getString(UserDetailActivity.EXTRA_FRAGMENT).toString()
        )
    }

    private fun setDataToFragment(listFollowing: List<GithubUser>) {
        val listUser = ArrayList<GithubUser>()
        binding?.apply {
            for (user in listFollowing) {
                listUser.clear()
                listUser.addAll(listFollowing)
            }
            rvFollower.layoutManager = LinearLayoutManager(context)
            val adapter = FollowsAdapter(listFollowing)
            rvFollower.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}