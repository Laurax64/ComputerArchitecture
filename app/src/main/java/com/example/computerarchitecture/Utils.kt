package com.example.computerarchitecture

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

/**
 * Opens the given URL in a custom tab.
 *
 * @param url The URL to open
 * @param context The context of the activity
 */
fun openWebsite(url: String, context: Context) {
    val intent = CustomTabsIntent.Builder()
        .build()
    intent.launchUrl(context, Uri.parse(url))
}