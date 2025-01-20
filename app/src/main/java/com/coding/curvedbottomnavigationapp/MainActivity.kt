package com.coding.curvedbottomnavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.coding.curvedbottomnavigationapp.fragments.HistoryFragment
import com.coding.curvedbottomnavigationapp.fragments.HomeFragment
import com.coding.curvedbottomnavigationapp.fragments.NotificationFragment
import com.coding.curvedbottomnavigationapp.fragments.PickupFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import com.qamar.curvedbottomnaviagtion.findFont

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Home",R.drawable.ic_home)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Pickup",R.drawable.ic_pickup)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"History",R.drawable.ic_history)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(4,"Notification",R.drawable.ic_notifications)
        )

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment())
                }
                2 -> {
                    replaceFragment(PickupFragment())
                }
                3 -> {
                    replaceFragment(HistoryFragment())
                }
                4 -> {
                    replaceFragment(NotificationFragment())
                }
            }
        }

        // default Bottom Tab Selected
        replaceFragment(HomeFragment())
        bottomNavigation.show(1)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}