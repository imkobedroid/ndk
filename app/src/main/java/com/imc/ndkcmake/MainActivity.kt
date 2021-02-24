package com.imc.ndkcmake

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("UnsafeDynamicallyLoadedCode")
class MainActivity : AppCompatActivity() {


    init {
        System.loadLibrary("test-lib-name_release")
    }


    private external fun test(encrypted: String): String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn).setOnClickListener {
            val s = test("hello world")
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        }
    }
}