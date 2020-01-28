package com.petnagy.navigatordemo.modules.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.petnagy.navigatordemo.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : DaggerAppCompatActivity() {

    private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when(menuItem.itemId) {
            R.id.navigation_home -> {
                openFragment(DashboardFragment.newInstance())
                true
            }
            R.id.navigation_list -> {
                openFragment(ListFragment.newInstance())
                true
            }
            R.id.navigation_preference -> {
                openFragment(PreferenceFragment.newInstance())
                true
            }
            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        bottom_navigation.setOnNavigationItemSelectedListener(navigationListener)
        openFragment(DashboardFragment.newInstance())
    }

    private fun openFragment(fragment: Fragment) {
        val transaction =  supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}