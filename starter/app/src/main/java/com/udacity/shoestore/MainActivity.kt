package com.udacity.shoestore

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.*
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private var lockBackPress: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dogViewModel = ViewModelProvider(this).get(DogViewModel::class.java)
        dogViewModel.refreshDogs()
        Timber.plant(Timber.DebugTree())

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.loginFragment, R.id.dogListFragment)
        )

        val navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _: NavController, navDestination: NavDestination, _: Bundle? ->
            lockBackPress = when (navDestination.id) {
                R.id.dogListFragment -> true
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return (Navigation.findNavController(this, R.id.myNavHostFragment).navigateUp())
    }

    override fun onBackPressed() {
        if (lockBackPress) {
            return
        }
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item, findNavController(R.id.myNavHostFragment)
        ) || super.onOptionsItemSelected(item)
    }

}
