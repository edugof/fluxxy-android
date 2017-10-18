package com.fluxxy

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        Log.i(Constants.LOG, "Button was pressed")
    }
}
