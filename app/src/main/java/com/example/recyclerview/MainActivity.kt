package com.example.recyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
lateinit var  adapter : Adapter
lateinit var removeadapter : Adapter
val removeditems = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstrc = findViewById<RecyclerView>(R.id.recyclerView2)
        firstrc.layoutManager = LinearLayoutManager(this)

        val secondrc = findViewById<RecyclerView>(R.id.recyclerView1)
        secondrc.layoutManager = LinearLayoutManager(this)



        val items = fetchData()
         adapter = Adapter(ArrayList(), this)
        firstrc.adapter = adapter

        removeadapter = Adapter(ArrayList(), this)
        secondrc.adapter = removeadapter

        adapter.updateList(items)
        adapter.onItemClicked={
            removeditems.add(items[it])
            removeadapter.updateList(removeditems)
            items.removeAt(it)
            adapter.updateList(items)

        }
       findViewById<Button>(R.id.button).setOnClickListener {
           val r1 = Random()

           for (i in items.size - 1 downTo 1) {
               // swapping current index value
               // with random index value
               Collections.swap(items, i, r1.nextInt(i + 1))
           }
           adapter.updateList(items)
       }

    }
    private  fun fetchData() :ArrayList<String>{
        val list = ArrayList<String>()
        for (i in 0 until 10){
            list.add("Item $i")
        }
        return list
    }
}