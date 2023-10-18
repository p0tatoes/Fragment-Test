package com.example.fragmentest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fragmentest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Buttons
//    private lateinit var inputEntriesButton: Button
//    private lateinit var qpiCalculatorButton: Button
//    private lateinit var playViewButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        inputEntriesButton = findViewById(R.id.redirectInputEntries)
//        inputEntriesButton.setOnClickListener {
//            val toInputEntries: Intent = Intent(this, InputEntries::class.java)
//            startActivity(toInputEntries)
//        }
//
//        qpiCalculatorButton = findViewById(R.id.redirectQPI)
//        qpiCalculatorButton.setOnClickListener {
//            val toQPICalculator: Intent = Intent(this, QPICalculator::class.java)
//            startActivity(toQPICalculator)
//        }
//
//        playViewButton = findViewById(R.id.redirectPlay)
//        playViewButton.setOnClickListener {
//            val toPlayView: Intent = Intent(this, PlayView::class.java)
//            startActivity(toPlayView)
//        }
    }
}