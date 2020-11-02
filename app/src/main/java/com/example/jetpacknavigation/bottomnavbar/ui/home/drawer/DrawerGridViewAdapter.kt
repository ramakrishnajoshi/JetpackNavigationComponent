package com.example.jetpacknavigation.bottomnavbar.ui.home.drawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpacknavigation.R
import com.example.jetpacknavigation.bottomnavbar.ui.home.drawer.DrawerGridViewAdapter.*
import kotlinx.android.synthetic.main.item_drawer.view.*

class DrawerGridViewAdapter(val drawerItems : List<DrawerGridItem>) : RecyclerView.Adapter<DrawerItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawerItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_drawer, parent, false)
        return DrawerItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drawerItems.size
    }

    override fun onBindViewHolder(holder: DrawerItemViewHolder, position: Int) {
        holder.itemView.imageViewDrawerIcon.setImageResource(R.drawable.ic_menu_settings)
        holder.itemView.imageViewDrawerIcon.setBackgroundResource(R.drawable.background_solid_circle)
    }

    inner class DrawerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
