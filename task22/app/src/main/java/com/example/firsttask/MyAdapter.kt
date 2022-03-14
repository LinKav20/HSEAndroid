package com.example.firsttask

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class MyAdapter(var ctx: Context, var resourses: Int, var items: List<ContactModel>) :
    ArrayAdapter<ContactModel>(ctx, resourses, items) {

    val REQUEST_PHONE_CALL = 1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resourses, null)

        val imageView: ImageView = view.findViewById(R.id.avatarImage)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val phoneTextView: TextView = view.findViewById(R.id.phoneTextView)
        val layout: LinearLayout = view.findViewById(R.id.call)

        val contact: ContactModel = items[position];
        imageView.setImageDrawable(ctx.resources.getDrawable(contact.image))
        nameTextView.text = contact.name
        phoneTextView.text = contact.phone

        layout.setOnClickListener {
            makePhoneCall(ctx, contact.phone)
        }

        return view
    }

    private fun makePhoneCall(ctx: Context, phone: String) {
        Toast.makeText(ctx, "Start calling", Toast.LENGTH_SHORT).show()
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:" + phone)
        startActivity(ctx, intent, null)
    }



}