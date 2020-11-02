package com.example.jetpacknavigation.bottomnavbar

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpacknavigation.R
import com.example.jetpacknavigation.bottomnavbar.ui.home.drawer.DrawerGridItem
import com.example.jetpacknavigation.bottomnavbar.ui.home.drawer.DrawerGridViewAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.drawer_layout.*

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)

        bottom_navigation.setupWithNavController(navController)

        //add animation
        val actionBarDrawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX: Float = drawerView.getWidth() * slideOffset
                app_bar_main.translationX = slideX
            }
        }
        drawer_layout.addDrawerListener(actionBarDrawerToggle)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // If a fragment id is not mentioned here, then when that fragment
        // is clicked, we will see back(up) arrow instead of hamburger
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_profile, R.id.nav_settings
            ), drawer_layout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        setDrawer()
    }

    private fun setDrawer() {
        drawer_layout.setScrimColor(Color.TRANSPARENT);

        val drawerAdapter = DrawerGridViewAdapter(
            listOf(
                DrawerGridItem(R.drawable.ic_menu_settings),
                DrawerGridItem(R.drawable.ic_menu_settings),
                DrawerGridItem(R.drawable.ic_menu_settings),
                DrawerGridItem(R.drawable.ic_menu_settings),
                DrawerGridItem(R.drawable.ic_menu_settings),
                DrawerGridItem(R.drawable.ic_menu_settings),
                DrawerGridItem(R.drawable.ic_menu_settings)
            )
        )

        val gridLayoutManager = GridLayoutManager(this@HomeActivity, 3, LinearLayoutManager.VERTICAL, false)

        //Make the last item center horizontally
        gridLayoutManager.setSpanSizeLookup(object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 6) 3 else 1
            }
        })

        recyclerviewDrawer.apply {
            layoutManager = gridLayoutManager
            adapter = drawerAdapter
        }
    }

    //Below method is required, otherwise nothing happens on click of hamburger icon
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
