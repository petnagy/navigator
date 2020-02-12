package com.petnagy.navigatordemo.modules.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.petnagy.navigatordemo.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import timber.log.Timber

class DashboardActivity : DaggerAppCompatActivity() {

    private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
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

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            val backStack = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 2)
            backStack.name?.let { fragmentName ->
                Timber.d("FragmentName: $fragmentName")
                selectBottomNavItem(fragmentName)
            }
        }
        super.onBackPressed()
    }

    private fun selectBottomNavItem(fragmentClassName: String) {
        bottom_navigation.setOnNavigationItemSelectedListener(null)
        bottom_navigation.selectedItemId = when(fragmentClassName) {
            DashboardFragment::class.java.name -> R.id.navigation_home
            ListFragment::class.java.name -> R.id.navigation_list
            PreferenceFragment::class.java.name -> R.id.navigation_preference
            else -> R.id.navigation_home
        }
        bottom_navigation.setOnNavigationItemSelectedListener(navigationListener)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
            .addToBackStack(fragment::class.java.name)
            .commit()
    }
}