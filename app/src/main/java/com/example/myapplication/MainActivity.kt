package com.example.myapplication
import android.content.Intent
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    private lateinit var btnAuth:Button
    private var cancellationSignal:CancellationSignal?=null
    private val authenticationCallback : BiometricPrompt.AuthenticationCallback
        get()=
            @RequiresApi(Build.VERSION_CODES.P)
            object: BiometricPrompt.AuthenticationCallback(){
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                    Toast.makeText(applicationContext, "Authentication Error $errString", Toast.LENGTH_SHORT).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                    Toast.makeText(applicationContext, "Authentication Success", Toast.LENGTH_SHORT).show()
                    startActivity(
                        Intent(
                            applicationContext,
                            HomePage::class.java
                        )
                    )
                }
            }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnAuth = findViewById(R.id.btnAuth)

        btnAuth.setOnClickListener {
            //view
            val biometricPrompt:BiometricPrompt=BiometricPrompt.Builder(this)
                .setTitle("Scan Finger")
                .setSubtitle("Authentication is Required")
                .setDescription("This app uses biometric recognition")
                .setNegativeButton("Cancel",mainExecutor) { _, _ ->
                    Toast.makeText(
                        applicationContext,
                        "Authentication Canceled",
                        Toast.LENGTH_SHORT
                    ).show()
                }.build()
            biometricPrompt.authenticate(
                getCancellationSignal(),
                mainExecutor,
                authenticationCallback
            )
        }

    }
    private fun getCancellationSignal():CancellationSignal {
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            Toast.makeText(this, "Authentication Canceled", Toast.LENGTH_SHORT).show()
        }
        return cancellationSignal as CancellationSignal
    }
}