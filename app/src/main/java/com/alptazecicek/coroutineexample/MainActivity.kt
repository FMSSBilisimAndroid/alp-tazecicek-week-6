package com.alptazecicek.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        while(true) {
            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.v("PATIKA", answer.toString())
                }
            }
        }
    }
    suspend fun doNetworkCall(): String {
        delay(2000L)
        return "NetworkCallAnswer"
    }
}