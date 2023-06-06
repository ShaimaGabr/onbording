package com.example.onbording

import android.app.Activity
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class CustomAdap (private val context: Activity, private val imageIdList: Array<Uri>)
    : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.overrow,null)
       // val imageView = rowView.findViewById(R.id.image_item)
       // imageView.setImageResource(imageIdList[p0])
        return rowView
    }
    override fun getItem(p0: Int): Any {
        return imageIdList.get(p0)
    }
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getCount(): Int {
        return imageIdList.size
    }
}