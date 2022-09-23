package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
//why we need two of these, and what does the colon do.

class WishlistAdapter (private val wishlist: MutableList<Data>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row

//        why I do this, is it just declarative programming thing?
        var item_name:TextView
        var price: TextView
        var store: TextView


        init {
            item_name = itemView.findViewById<TextView>(R.id.item_name)
            price = itemView.findViewById<TextView>(R.id.price)
            store = itemView.findViewById<TextView>(R.id.store)
        }
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val wishlistView = inflater.inflate(R.layout.item_wishlist, parent, false)
        // Return a new holder instance
        return ViewHolder(wishlistView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: WishlistAdapter.ViewHolder, position: Int) {
        // Get the data model based on position, should it be this?
        val userlist = wishlist[position]

        // Set item views based on your views and data model
        viewHolder.item_name.text = userlist.item.toString()
        viewHolder.price.text = userlist.price.toString()
        viewHolder.store.text = userlist.store.toString()
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return wishlist.size
    }
}