package com.example.computerarchitecture.ui.components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Displays a web view.
 *
 * @param url The URL to load in the web view
 */
@Composable
fun WebViewScreen(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}
