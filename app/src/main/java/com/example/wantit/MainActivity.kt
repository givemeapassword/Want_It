package com.example.wantit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import android.content.Intent
import android.view.View
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var TabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        val fragments: ArrayList<Fragment> = arrayListOf(
            PageMainFragment(),
            PageSecondFragment()
        )
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        //реализация TabLayout

        //TabLayout = findViewById(R.id.tabLayout)
        }

    fun clickSetting(view: View){
        //переход на настройки
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)
    }
    fun clickBack(view: View){
        //переход на настройки
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}