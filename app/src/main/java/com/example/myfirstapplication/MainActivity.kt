package com.example.myfirstapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.etUserEmail)
        val password = findViewById<EditText>(R.id.etUserPassword)

        val errorSnackBar = Snackbar.make(
            findViewById(R.id.main),
            "Error",
            Snackbar.LENGTH_SHORT
        )

        val successSnackBar = Snackbar.make(
            findViewById(R.id.main),
            "Success",
            Snackbar.LENGTH_SHORT
        )


        fun verifyEmail(email: String): Boolean {
            return (email.contains("@") && email.contains(".com") && email.isNotEmpty())
        }

        fun verifyPassword(password: String): Boolean {
            val specialCharacterPattern = Regex("[^a-zA-Z0-9 ]")
            val lowerCasePattern = Regex("[a-z]")
            val upperCasePattern = Regex("[A-Z]")
            return (password.length == 8 && password.contains(specialCharacterPattern) && password.contains(lowerCasePattern) && password.contains(upperCasePattern) && password.isNotEmpty())

        }

        findViewById<Button>(R.id.btnSubmitLogin).setOnClickListener {
            val submittedEmail = email.text.toString()
            val submittedPassword = password.text.toString()

            if (verifyEmail(submittedEmail) && verifyPassword(submittedPassword)) {
                successSnackBar.show()
            }
            else {
                errorSnackBar.show()
            }

            // TODO: Create the logic to verify user login details, EMAIL should be valid, Password must have 8 length including small/capital letters with digit and special characters


        }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}