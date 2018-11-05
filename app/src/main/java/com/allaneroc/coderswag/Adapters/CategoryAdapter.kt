package com.allaneroc.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.allaneroc.coderswag.Model.Category
import com.allaneroc.coderswag.R

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder : ViewHolder

//Null check: if convertView == null, we will inflate it.
        if (convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()

            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

//        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
//        val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
//        val categoryName : TextView = categoryView.findViewById(R.id.categoryName)


        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title
        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

//We are not using getItemId.
    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()   //Tells listview how many rows will be displayed.
    }

//Allows us to reuse and recycle our views.
    private class ViewHolder {
        var categoryImage : ImageView? = null
        var categoryName : TextView? = null
    }
}