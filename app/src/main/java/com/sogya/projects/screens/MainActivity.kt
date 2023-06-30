package com.sogya.projects.screens

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sogya.projects.R
import com.sogya.projects.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var topBarTittle: TextView
    private lateinit var vm: MainVM
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme()
        //Попробовать проверку биндинга на нулл для рекрейта активити
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        vm = ViewModelProvider(this).get(MainVM::class.java)
        topBarTittle = findViewById(R.id.topBarTittle)

        setupNavigation()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.listFragment -> {
                    binding.buttonGoBack.visibility = GONE
                    binding.buttonChangeTheme.visibility = VISIBLE
                }
                R.id.mapFragment -> {
                    binding.buttonChangeTheme.visibility = GONE
                    binding.buttonGoBack.visibility = VISIBLE
                }
            }
        }
        binding.buttonGoBack.setOnClickListener {
            onBackPressed()
        }

        binding.buttonChangeTheme.setOnClickListener {
            vm.setTheme(object : myCallBack<Boolean> {
                override fun data(t: Boolean) {
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
                    finish()
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