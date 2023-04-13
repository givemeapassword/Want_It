package com.example.wantit

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.GridView
import androidx.annotation.RequiresApi

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    private var view: View? = null
    private var gridView: GridView? = null
    private var arrayList: ArrayList<GridItem>? = null
    private var gridAdapter: GridAdapter? = null




    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get_permission()

        //viewPager
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        val fragments: ArrayList<Fragment> = arrayListOf(
            PageMainFragment(),
            PageSecondFragment()
        )
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter




        //переход
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                gridView = findViewById(R.id.gridview)
                arrayList = ArrayList()
                arrayList = setDataList()
                gridAdapter = GridAdapter(applicationContext, arrayList!!)
                gridView?.adapter = gridAdapter
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {

                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

        })
        }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0]!= PackageManager.PERMISSION_GRANTED){
            get_permission()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun get_permission() {
        if (ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 101)
        }
    }

    //переход на настройки
    fun clickSetting(view: View){
        startActivity(Intent(this, SettingsActivity::class.java))
    }
    fun camActivity(view: View){
        startActivity(Intent(this,CameraPageActivity::class.java))
    }
    private fun setDataList(): ArrayList<GridItem> {
        val arrayList: ArrayList<GridItem> = ArrayList()
        //todo реализовать базу данных со списком фото
        arrayList.add(GridItem(R.drawable.icons8, "fffff"))
        arrayList.add(GridItem(R.drawable.icons8, "fffff"))
        arrayList.add(GridItem(R.drawable.icons8, "fffff"))
        arrayList.add(GridItem(R.drawable.icons8, "fffff"))
        arrayList.add(GridItem(R.drawable.icons8, "fffff"))
        arrayList.add(GridItem(R.drawable.icons8, "fffff"))
        arrayList.add(GridItem(R.drawable.icons8, "fffff"))

        return arrayList
    }



}