package com.example.computerarchitecture

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Opens a [WebView] with the given [url].
 *
 * @param url The URL to open in the [WebView]
 */
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun OpenWebView(url: String, modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                loadUrl(url)
            }
        },

        )
}