package com.example.computerarchitecture

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Opens a [WebView] with the given [url].
 *
 * @param url The URL to open in the [WebView]
 */
@Composable
fun OpenWebView(url: String) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            webViewClient = WebViewClient()
            loadUrl("https://hpc-tutorials.llnl.gov/posix/creating_and_terminating/#creating-threads")
        }
    })
}