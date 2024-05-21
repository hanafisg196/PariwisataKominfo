package com.example.pariwisatakominfo.helper

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.Toast
import org.jsoup.Jsoup

fun parseHtml(htmlContent: String): String {
    val document = Jsoup.parse(htmlContent)
    return document.text()
}

@SuppressLint("QueryPermissionsNeeded")
fun openMapLocation(context: Context, url: String)
{
    val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(url))
    intent.setPackage("com.google.android.apps.maps")
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        Toast
            .makeText(context, "Google Maps App not found", Toast.LENGTH_SHORT)
            .show()
    }
}


