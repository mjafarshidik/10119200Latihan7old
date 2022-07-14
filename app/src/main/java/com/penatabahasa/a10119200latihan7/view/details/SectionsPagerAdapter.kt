package com.penatabahasa.a10119200latihan7.view.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.penatabahasa.a10119200latihan7.view.details.follows.FollowerFragment
import com.penatabahasa.a10119200latihan7.view.details.follows.FollowingFragment

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class SectionsPagerAdapter(activity: AppCompatActivity, private val login: Bundle) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2


    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FollowerFragment()
            1 -> fragment = FollowingFragment()
        }
        fragment?.arguments = login
        return fragment as Fragment
    }
}