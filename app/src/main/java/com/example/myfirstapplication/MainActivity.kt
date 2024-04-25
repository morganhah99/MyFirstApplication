package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val MyTag = "MainActivity"

    var counter = 0

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

//        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

//        val email = findViewById<EditText>(R.id.etUserEmail)
//        val password = findViewById<EditText>(R.id.etUserPassword)


//        findViewById<Button>(R.id.btnSubmitLogin).setOnClickListener {
        binding.btnSubmitLogin.setOnClickListener {
            // write logic to hanlde the button
            val submittedEmail = binding.etUserEmail.text.toString()
            val submittedPassword = binding.etUserPassword.text.toString()

            // TODO: Create the logic to verify user login details, EMAIL should be valid, Password must have 8 length including small/capital letters with digit and special characters

            //Navigation to another activity
            val intent = Intent(this, ScrollingActivity::class.java)
            startActivity(intent)
        }

        Log.d(MyTag, "OnCreate -> Attaches the UI, prepares the assets to be displayed.")

//        val counterText = findViewById<TextView>(R.id.tvLoginTitle)
//        findViewById<Button>(R.id.btnSubmitLogin).setOnClickListener {
//            counter++
//            counterText.text = counter.toString()
//        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(
            MyTag,
            "OnStart -> Allocates the memory for resources, preparing to display UI to the user"
        )
    }

    override fun onResume() {
        super.onResume()
        Log.d(
            MyTag,
            "OnResume -> User can see and interact with the UI"
        ) //only place user gets to interact
    }

    override fun onPause() {
        super.onPause()
        Log.d(
            MyTag,
            "OnPause -> Puts the UI on temporary hold, all the assets are still alive just not visible to the USER"
        )
    }

    override fun onStop() {
        super.onStop()
        Log.d(
            MyTag,
            "OnStop -> Clear/free the memory resources, only exists the reference of elements"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MyTag, "OnDestroy -> Destroys the reference of resources and activity itself")
    }

}