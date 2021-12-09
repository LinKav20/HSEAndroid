package com.example.firsttask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (var ctx: Context, var resourses:Int, var items:List<ContactModel>)
    : ArrayAdapter<ContactModel> (ctx, resourses, items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(ctx)
        val view:View = layoutInflater.inflate(resourses, null)

        val imageView:ImageView = view.findViewById(R.id.avatarImage)
        val nameTextView:TextView = view.findViewById(R.id.nameTextView)
        val phoneTextView:TextView = view.findViewById(R.id.phoneTextView)

        val contact:ContactModel = items[position];
        imageView.setImageDrawable(ctx.resources.getDrawable(contact.image))
        nameTextView.text = contact.name
        phoneTextView.text = contact.phone

        return view
    }
}