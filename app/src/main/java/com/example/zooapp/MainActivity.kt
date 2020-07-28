package com.example.zooapp

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.*
import kotlinx.android.synthetic.main.animal_ticket.view.*
import java.util.zip.Inflater

  class MainActivity : AppCompatActivity() {
    var listOfAnimals=ArrayList<Animal>()
     var adapter:AnimalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Load Animals
        listOfAnimals.
        add(Animal("Baboon","Baboons vary in size and weight depending on the species. The smallest, " +
                "the Kinda Baboon, is 50 cm  ",R.drawable.baboon,true))
        listOfAnimals.
        add(Animal("BullDog","Bulldogs are recognized as excellent family pets because of their tendency to form strong bonds with children.",R.drawable.bulldog,true))
        listOfAnimals.
        add(Animal("Panda"," Giant pandas are good at climbing trees and can also swim. Pandas are " +
                "lazy— eating and sleeping make their day",R.drawable.panda,false))
        listOfAnimals.
        add(Animal("Zebra","Zebra are part of the equidae family along with horse and donkeys. Every zebra has a " +
                "unique pattern of black and white stripes.",R.drawable.zebra,false))
        listOfAnimals.
        add(Animal("Swallow bird","Swallows are small birds with dark, glossy-blue backs, " +
                "red throats, pale underparts and long tail streamers",R.drawable.swallow_bird,false))
        listOfAnimals.
        add(Animal("White tiger","White Tigers are also known as white Bengal tigers. They are not albino nor a sub-species of tiger but actually are Bengal tigers with a genetic defect that expresses a different color. White tigers lack the pigment called pheomelanin, " +
                "which is found in Bengal tigers with orange fur.",R.drawable.white_tiger,true))
        adapter=AnimalAdapter(this,listOfAnimals)
        TvListAnimal.adapter=adapter
    }
  /* fun delete(index:Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }*/
/*fun add(index: Int){
    listOfAnimals.add(index,listOfAnimals[index])
    adapter!!.notifyDataSetChanged()
}*/


   inner class AnimalAdapter:BaseAdapter{
        var listOfAnimals = ArrayList<Animal>()
        var context: Context?=null
        constructor(context:Context, listOfAnimals:ArrayList<Animal>):super(){
         this.listOfAnimals=listOfAnimals
            this.context=context
        }
        @RequiresApi(Build.VERSION_CODES.M)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            if (animal.isKiller == true) {
                var inflator =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_killer_ticket
                    , null)
                myView.TvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener {
                    //add(position)
                    val intent=Intent(context,AnimalInfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image", animal.image!!)
                  context!!.startActivity(intent)
                }
                return myView
            } else {
                var inflator =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.TvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener {
                   // add(position)
                    val intent=Intent(context,AnimalInfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)

                }
                return myView

            }
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
         return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}