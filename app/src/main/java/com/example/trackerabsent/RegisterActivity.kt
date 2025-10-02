package com.example.trackerabsent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var tvLogin: TextView
    private lateinit var etSchoolID: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var etCourse: TextInputEditText
    private lateinit var layoutSchooldID: TextInputLayout
    private lateinit var layoutPasswordd: TextInputLayout
    private lateinit var layoutConfirmPassword: TextInputLayout
    private lateinit var layoutCourse: TextInputLayout
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // connect TextView
        tvLogin = findViewById(R.id.tvLogin)

        // connect EditTexts and Layouts
        etSchoolID = findViewById(R.id.schooldID)
        etPassword = findViewById(R.id.password)
        etConfirmPassword = findViewById(R.id.confirmPassword)
        etCourse = findViewById(R.id.course)

        layoutSchooldID = findViewById(R.id.layoutSchooldID)
        layoutPasswordd = findViewById(R.id.layoutPasswordd)
        layoutConfirmPassword = findViewById(R.id.layoutConfirmPassword)
        layoutCourse = findViewById(R.id.layoutCourse)

        btnRegister = findViewById(R.id.btnRegister)

        // click listener sa "Already have account? Login here"
        tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // slide MainActivity from left, RegisterActivity slides right
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        btnRegister.setOnClickListener {
            val schoolID = etSchoolID.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()
            val course = etCourse.text.toString().trim()

            var isValid = true

            // reset errors
            layoutSchooldID.error = null
            layoutPasswordd.error = null
            layoutConfirmPassword.error = null
            layoutCourse.error = null

            if (schoolID.isEmpty()) {
                layoutSchooldID.error = "Please enter School ID"
                isValid = false
            }
            if (password.isEmpty()) {
                layoutPasswordd.error = "Please enter Password"
                isValid = false
            }
            if (confirmPassword.isEmpty()) {
                layoutConfirmPassword.error = "Please confirm Password"
                isValid = false
            }
            if (course.isEmpty()) {
                layoutCourse.error = "Please enter Course"
                isValid = false
            }

            if (isValid && password != confirmPassword) {
                layoutPasswordd.error = "Passwords do not match"
                layoutConfirmPassword.error = "Passwords do not match"
                isValid = false
            }

            if (isValid) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            } else {
                Toast.makeText(this, "Please complete the required fields", Toast.LENGTH_SHORT).show()
            }
        }

        // back button behavior
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            }
        })
    }
}
