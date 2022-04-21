package com.sogya.projects

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sogya.projects.app.App
import com.sogya.projects.databinding.ActivityMainBinding
import com.sogya.projects.instruments.OnDataPass
import com.sogya.projects.instruments.myCallBack

class MainActivity : AppCompatActivity(), OnDataPass {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var topBarTittle: TextView
    private lateinit var vm: MainVM
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        if (App.getInstance().isNightModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        vm = ViewModelProvider(this).get(MainVM::class.java)
        topBarTittle = findViewById(R.id.topBarTittle)

        setupNavigation()

        binding.buttonChangeTheme.setOnClickListener {
            vm.setTheme(object : myCallBack<Boolean> {
                override fun data(t: Boolean) {
                    finish()
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                }
            })
        }
    }

    private fun setupNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onDataPass(data: String) {
        topBarTittle.text = data
    }

    override fun onBackPressed() {
        super.onBackPressed()
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
    }

}