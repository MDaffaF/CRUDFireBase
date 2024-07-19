package com.example.daffa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Default : AppCompatActivity() {
    private lateinit var login: Button
    private lateinit var register: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)

        mAuth = FirebaseAuth.getInstance()

        login = findViewById(R.id.loginButton)
        register = findViewById(R.id.registerButton)

        login.setOnClickListener {
            startActivity(Intent(this@Default, LoginActivity::class.java))
        }
        register.setOnClickListener {
            startActivity(
                Intent(
                    this@Default, RegisterActivity::class.java
                )
            )
        }
        checkUserSession()
    }

    private fun checkUserSession() {
        val currentUser: FirebaseUser? = mAuth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this@Default, MainActivity::class.java))
            finish()
        }
    }
}
