package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Are we supposed to put it here?
class MainActivity : AppCompatActivity() {
    private val wishlist = mutableListOf<Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ...
        // Lookup the recyclerview in activity layout
        val wishlists = findViewById<RecyclerView>(R.id.Wishlist)
        // Create adapter passing in the sample user data
        val adapter = WishlistAdapter(wishlist)
        // Attach the adapter to the recyclerview to populate items
        wishlists.adapter = adapter
        // Set layout manager to position the items
        wishlists.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
        //how to connect?
        // That's all
        var button = findViewById<Button>(R.id.add)
        var item_name = findViewById<EditText>(R.id.item_name)
        var price = findViewById<EditText>(R.id.item_price)
        var store = findViewById<EditText>(R.id.item_store)
//        should this be inside or outside the button listener.

        button.setOnClickListener() {
            //var item = item_name.text.toString()
            //var price = price.text.toString().toDouble()
            //var store = store.text.toString()
            var addlist:Data = Data(item_name.text.toString(), price.text.toString().toDouble(), store.text.toString())
            wishlist.add(addlist)
        }
        adapter.notifyDataSetChanged()
        wishlists.scrollToPosition(wishlist.size -1)

    }
}



