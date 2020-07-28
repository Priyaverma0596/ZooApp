package com.example.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*
import kotlinx.android.synthetic.main.animal_ticket.*
import kotlinx.android.synthetic.main.activity_animal_info.ivAnimalImage as ivAnimalImage1
import kotlinx.android.synthetic.main.activity_animal_info.tvDes as tvDes1

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        val bundle: Bundle? =intent.extras
        val name=bundle!!.getString("name")
        val des=bundle!!.getString("des")
        val image=bundle!!.getInt("image")
        ivAnimalImage.setImageResource(image)
        tvName.text=name
        tvDes.text=des

    }
}