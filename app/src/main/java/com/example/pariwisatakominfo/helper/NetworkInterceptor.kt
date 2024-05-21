package com.example.pariwisatakominfo.helper

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException

class NetworkInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            chain.proceed(chain.request())
        } catch (e: IOException) {

            Handler(Looper.getMainLooper()).post {
                Toast.makeText(context, "Something Wrong: ${e.message}", Toast.LENGTH_LONG).show()
            }
            throw e
        }
    }
}