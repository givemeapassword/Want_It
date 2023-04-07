package com.example.wantit

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.content.Context
import android.widget.TextView
import android.widget.ImageView

class GridAdapter(var context: Context, var arrayList: ArrayList<GridItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.grid_item, null)
        val icons: ImageView = view.findViewById(R.id.grid_image)
        val names: TextView = view.findViewById(R.id.item_name)

        val GridItem: GridItem = arrayList.get(p0)

        icons.setImageResource(GridItem.icons!!)
        names.text = GridItem.name

        return view

    }
}