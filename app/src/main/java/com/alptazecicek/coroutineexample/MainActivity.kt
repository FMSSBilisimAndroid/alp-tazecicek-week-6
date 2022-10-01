package com.alptazecicek.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // counter initilized.
        var counter = 0

        // Coroutine Scope added in to infinite while loop.
        while(true) {
            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.v("PATIKA", answer.toString())
                }
                counter += 1
            }
        }
        //this code is unreachable because of main thread infinite loop.
        println(counter)
    }
    //suspend function defined with 2 sec delay.
    suspend fun doNetworkCall(): String {
        delay(2000L)
        return "NetworkCallAnswer"
    }
}