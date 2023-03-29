package com.example.wantit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        val fragments: ArrayList<Fragment> = arrayListOf(
            Page2Fragment(),
            Page3Fragment()
        )
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter
        }
    fun ClickSetting(view: View){
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)
    }
}