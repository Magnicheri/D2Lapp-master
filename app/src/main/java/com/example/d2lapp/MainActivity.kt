package com.example.d2lapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.d2lapp.databinding.ActivityMainBinding
import com.example.d2lapp.ui.home.HomeFragment
import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.visibility = View.GONE

        val loginButton: Button = findViewById(R.id.button2)
        loginButton.setOnClickListener {

            val enteredUsername: EditText = findViewById(R.id.username)
            val enteredPassword: EditText = findViewById(R.id.password)
            val u = enteredUsername.text.toString()
            val p = enteredPassword.text.toString()

            var loginValidation = ""

            if(u == "root" && p == "key"){
                loginValidation = "welcome"

                // Get the NavController instance
                val navController = findNavController(R.id.nav_host_fragment_activity_main)

                // Navigate to the HomeFragment
                navController.navigate(R.id.navigation_home)

                binding.navView.visibility = View.VISIBLE
            }
            else{
                loginValidation = "invalid login info"

            }
            val toast = Toast.makeText(this, loginValidation, Toast.LENGTH_SHORT)
            toast.show()
        }




        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_Calender, R.id.navigation_Email
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }




}