package com.example.sivanb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BusinessActivity extends AppCompatActivity {


    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new load());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.instagram.com/sivan_beauty_t/");
    }
    private  class load extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String request) {

            view.loadUrl(request);

            return true;

        }
    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.iv_inst:
                webView.loadUrl(("https://www.instagram.com/sivan_beauty_t/"));
                break;
        }
    }

}
