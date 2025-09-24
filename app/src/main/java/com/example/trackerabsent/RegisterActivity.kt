package com.example.trackerabsent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var tvLogin: TextView
    private lateinit var etSchoolID: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var etCourse: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // connect TextView to go back to login
        tvLogin = findViewById(R.id.tvLogin)

        // connect EditTexts and Button
        etSchoolID = findViewById(R.id.schooldID)
        etPassword = findViewById(R.id.password)
        etConfirmPassword = findViewById(R.id.confirmPassword)
        etCourse = findViewById(R.id.course)
        btnRegister = findViewById(R.id.btnRegister)

        // click listener sa "Already have account? Login here"
        tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        // click listener sa Register button
        btnRegister.setOnClickListener {
            val schoolID = etSchoolID.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()
            val course = etCourse.text.toString().trim()

            when {
                schoolID.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || course.isEmpty() -> {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                }
                password != confirmPassword -> {
                    Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                    // example: balik sa login page
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                }
            }
        }

        // modern back button handling
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            }
        })
    }
}
