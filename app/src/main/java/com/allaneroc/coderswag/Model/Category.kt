package com.allaneroc.coderswag.Model

class Category(val title: String, val image: String) {

//categoryListView is showing links.
//Override below so it will return the title, not something else.
    override fun toString(): String {
        return title
    }
}