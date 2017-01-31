package com.edu.zscdm.internetdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView) findViewById(R.id.web_view);

        //设置网页
        WebSettings webSettings = webView.getSettings();
        webSettings.setDisplayZoomControls(true);//支持显示缩放
        webSettings.setJavaScriptEnabled(true);//支持JavaScript脚本
        webSettings.setSupportZoom(true);//支持缩放
        webView.loadUrl("https://www.baidu.com");

        //设置默认浏览器，不调用系统的浏览器
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }
    /**
     * 处理按键按下时的操作
     *
     * @param keyCode
     * @param event
     * @return boolean
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//如果按下的是返回键
            if (webView.canGoBack()) {//如果能够返回
                webView.goBack();
            } else {
                System.exit(0);//退出程序
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
