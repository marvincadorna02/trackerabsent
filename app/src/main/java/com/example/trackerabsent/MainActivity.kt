package com.example.trackerabsent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvRegister: TextView
    private lateinit var etSchoolID: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // connect sa TextView
        tvRegister = findViewById(R.id.tvRegister)

        // connect sa EditTexts ug Button
        etSchoolID = findViewById(R.id.schooldID)
        etPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btnLogin)

        // click listener para mo-navigate sa RegisterActivity
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        // click listener sa Login button
        btnLogin.setOnClickListener {
            val schoolID = etSchoolID.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (schoolID.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter School ID and Password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Successfully Login!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
