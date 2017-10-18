package com.fluxxy

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val okHttpClient = OkHttpClient().newBuilder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
        AndroidNetworking.initialize(applicationContext, okHttpClient)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        Log.i(Constants.LOG, "Button clicked!")
        AndroidNetworking.get("http://18.221.145.123:8000/")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsString(object : StringRequestListener {
                    override fun onResponse(response: String) {
                        Log.i(Constants.LOG, "Response: $response")
                    }

                    override fun onError(error: ANError) {
                        Log.i(Constants.LOG, "Error: ${error.errorBody}")
                    }
                })
    }
}
