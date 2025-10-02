package com.example.trackerabsent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tvRegister: TextView
    private lateinit var etSchoolID: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var layoutSchoolID: TextInputLayout
    private lateinit var layoutPassword: TextInputLayout
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // connect sa TextView
        tvRegister = findViewById(R.id.tvRegister)

        // connect sa TextInputLayouts ug EditTexts
        layoutSchoolID = findViewById(R.id.layoutSchoolID)
        layoutPassword = findViewById(R.id.layoutPassword)
        etSchoolID = findViewById(R.id.schooldID)
        etPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btnLogin)

        // click listener para mo-navigate sa RegisterActivity with slide animation
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            // slide RegisterActivity from right, MainActivity slides left
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }



        // click listener sa Login button
        btnLogin.setOnClickListener {
            val schoolID = etSchoolID.text.toString().trim()
            val password = etPassword.text.toString().trim()

            var isValid = true

            if (schoolID.isEmpty()) {
                layoutSchoolID.error = "Please enter School ID"
                isValid = false
            } else {
                layoutSchoolID.error = null
            }

            if (password.isEmpty()) {
                layoutPassword.error = "Please enter Password"
                isValid = false
            } else {
                layoutPassword.error = null
            }

            if (isValid) {
                Toast.makeText(this, "Successfully Login!", Toast.LENGTH_SHORT).show()

                // Navigate to DashboardActivity
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()  // optional para dili ka mo-back sa login
            }
        }

    }
}
