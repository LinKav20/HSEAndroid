package com.example.firsttask

import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var next: Button
    private lateinit var prev: Button
    private lateinit var title: TextView

    private var currentImage = 0
    private lateinit var images: ArrayList<String>

    private var path = "/res/drawable"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        next = findViewById(R.id.next_btn)
        prev = findViewById(R.id.prev_btn)
        title = findViewById(R.id.title)

        next.setOnClickListener { onNext() }
        prev.setOnClickListener { onPrev() }
    }

    override fun onResume() {
        super.onResume()
        currentImage = 0
        try {
            var imageDirectory = File(path)
            images = searchImage(imageDirectory)
            updatePhoto(Uri.parse(images.get(currentImage)))
        } catch (e: Exception) {
            title.text = path + " not found"
        }
    }

    override fun onPause() {
        super.onPause()
        images.clear()
    }

    private fun searchImage(imageDirectory: File): ArrayList<String> {
        var imagesFound = arrayListOf<String>()

        for (file in imageDirectory.listFiles()) {
            if (!file.isDirectory) {
                var fileExt = getFileExt(file.absolutePath)
                if (fileExt == "jpg" || fileExt == "png" || fileExt == "jpeg") {
                    imagesFound.add(file.absolutePath)
                }
            }
        }

        return imagesFound
    }

    private fun getFileExt(absolutePath: String): String {
        return absolutePath.substring(absolutePath.lastIndexOf(".") + 1);
    }

    private fun updatePhoto(uri: Uri) {
        try {
            imageView.setImageURI(uri)
        } catch (e: Exception) {
            title.text = "Loading mistake"
        }
    }

    private fun onNext() {
        if (currentImage + 1 < images.size && images.size > 0) {
            currentImage++;
            updatePhoto(Uri.parse(images[currentImage]))
        }
    }

    private fun onPrev() {
        if (currentImage > 0 && images.size > 0) {
            currentImage--;
            updatePhoto(Uri.parse(images[currentImage]));
        }
    }
}