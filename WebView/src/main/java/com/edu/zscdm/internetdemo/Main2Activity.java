package com.edu.zscdm.internetdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*********方式一*******/
        setContentView(R.layout.activity_main2);
        Uri uri = Uri.parse("https://www.baidu.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

        /*********方式二*******/
        WebView webview = new WebView(this);
        setContentView(webview);
        //1、加载Url资源
        webview.loadUrl("https://www.baidu.com");
        //2、加载html资源
        String summary = "<html><body>You scored <b>192</b> points.</body></html>";
        webview.loadData(summary, "text/html", null);

    }
}
