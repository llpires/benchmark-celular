package com.benchmark.celular;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private static final String TAG = "BenchmarkCelular";
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            webView = new WebView(this);
            WebSettings s = webView.getSettings();
            s.setJavaScriptEnabled(true);
            s.setDomStorageEnabled(true);
            s.setDatabaseEnabled(true);
            s.setAllowFileAccess(true);
            s.setAllowContentAccess(true);
            s.setLoadWithOverviewMode(true);
            s.setUseWideViewPort(true);
            s.setCacheMode(WebSettings.LOAD_DEFAULT);
            s.setMediaPlaybackRequiresUserGesture(false);
            s.setBuiltInZoomControls(false);
            s.setDisplayZoomControls(false);
            s.setSupportZoom(false);
            s.setJavaScriptCanOpenWindowsAutomatically(false);

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onReceivedError(WebView v, WebResourceRequest r, WebResourceError e) {
                    Log.e(TAG, "WV error: " + (e != null ? e.getDescription() : "?"));
                }
                @Override
                public void onPageFinished(WebView v, String u) {
                    Log.i(TAG, "Page OK: " + u);
                }
            });
            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public boolean onConsoleMessage(ConsoleMessage cm) {
                    Log.i(TAG, "JS: " + cm.message());
                    return true;
                }
            });
            webView.loadUrl("file:///android_asset/index.html");
            setContentView(webView);
        } catch (Exception e) {
            Log.e(TAG, "Fatal: " + e.getMessage(), e);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.stopLoading();
            webView.removeAllViews();
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
