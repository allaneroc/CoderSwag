package com.allaneroc.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.allaneroc.coderswag.Adapters.CategoryAdapter
import com.allaneroc.coderswag.Model.Category
import com.allaneroc.coderswag.R
import com.allaneroc.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//Creating a default adapter called 'adapter':
    lateinit var adapter : CategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Initializing the adapter created above.
//An ArrayAdapter needs: context, view, and data that needs adapting.
//Changed ArrayAdapter into CategoryAdapter in next lesson.
        adapter = CategoryAdapter(this, DataService.categories)

//Set adapter for categoryListView equal to the adapter that we just created.
        categoryListView.adapter = adapter
    }
}
