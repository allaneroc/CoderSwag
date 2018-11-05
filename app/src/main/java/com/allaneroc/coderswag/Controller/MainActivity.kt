package com.allaneroc.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.allaneroc.coderswag.Adapters.CategoryAdapter
import com.allaneroc.coderswag.Adapters.CategoryRecycleAdapter
import com.allaneroc.coderswag.Model.Category
import com.allaneroc.coderswag.R
import com.allaneroc.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//Creating a default adapter called 'adapter':
//    lateinit var adapter : CategoryAdapter
//Changed into this, when CategoryRecycleAdapter created:
    lateinit var adapter : CategoryRecycleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Initializing the adapter created above.
//An ArrayAdapter needs: context, view, and data that needs adapting.
//Changed ArrayAdapter into CategoryAdapter in next lesson.
//        adapter = CategoryAdapter(this, DataService.categories)

//Changed above into:
        adapter = CategoryRecycleAdapter(this, DataService.categories)

//Set adapter for categoryListView equal to the adapter that we just created.
        categoryListView.adapter = adapter

//Below will not work for RecyclerView (which we switch to in Lesson 05).
//Commented out.
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.categories[i]
//            Toast.makeText(this, "You clicked on the ${category.title} cell.", Toast.LENGTH_SHORT).show()
//        }

//Need Layout Manager
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
