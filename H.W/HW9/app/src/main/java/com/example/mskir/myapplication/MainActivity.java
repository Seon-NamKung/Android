package com.example.mskir.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText et;
    LinearLayout linear;
    Animation anim;
    ListView lv;
    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webview);
        et = (EditText)findViewById(R.id.et);
        final ProgressDialog dialog = new ProgressDialog(this);
        linear = (LinearLayout)findViewById(R.id.linear);
        lv = (ListView)findViewById(R.id.lv);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(adapter);

        webView.addJavascriptInterface(new JavaScriptMethods(),"myApp");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        //webSettings.setSupportZoom(true);


        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                dialog.setMessage("Loading...");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                et.setText(url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress>=100)dialog.dismiss();
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                result.confirm();
                return super.onJsAlert(view, url, message, result);
            }
        });

        anim = AnimationUtils.loadAnimation(this,R.anim.translate_top);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                linear.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String goUrl = getUrl(data.get(position));
                webView.setVisibility(View.VISIBLE);
                lv.setVisibility(View.GONE);
                webView.loadUrl(goUrl);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("삭제확인")
                        .setMessage("선택한 항목을 정말 삭제할까요?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                data.remove(position);;
                                adapter.notifyDataSetChanged();
                                Snackbar.make(view,"삭제되었습니다.",1000).setAction("확인",null).show();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .create()
                        .show();

                return false;
            }
        });
    }

    public void onClick(View v){
        if(v.getId() == R.id.btn1){
            String siteUrl = et.getText().toString();
            String temp;
            if(siteUrl.contains("https://")) temp = siteUrl;
            else temp = "https://" + siteUrl;
            webView.setVisibility(View.VISIBLE);
            lv.setVisibility(View.GONE);
            webView.loadUrl(temp);
        }
    }

     Boolean checkUrl(String url){
        for(int i = data.size()-1 ; i >= 0;i--){
            if(data.get(i).contains(url)) return true;
        }
        return false;
    }

    String getUrl(String list){
        String[] splited = list.split(" ");
        return splited[1];
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"즐겨찾기추가");
        menu.add(0,2,0,"즐겨찾기목록");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == 1){
            lv.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.VISIBLE);
            webView.loadUrl("file:///android_asset/www/urladd.html");
            linear.setAnimation(anim);
            anim.start();
        }else{
            lv.setVisibility(View.VISIBLE);
            linear.setVisibility(View.VISIBLE);
            webView.setVisibility(View.INVISIBLE);
            et.setText("");
        }
        return super.onOptionsItemSelected(item);
    }

    Handler myHandler = new Handler();
    public class JavaScriptMethods{
        @JavascriptInterface
        public void getUrl(final String siteName, final String siteUrl){
            myHandler.post(new Runnable() {
                @Override
                public void run() {

                    if(!checkUrl(siteUrl)){

                        String temp;
                        if(siteUrl.contains("https://")) temp = "<" + siteName + ">" + " " + siteUrl;
                        else temp = "<" + siteName + ">" + " " + "https://" + siteUrl;

                        data.add(temp);
                        adapter.notifyDataSetChanged();
                        webView.loadUrl("javascript:clear()");
                    }else{
                        webView.loadUrl("javascript:displayMsg()");
                    }
                }
            });
        }
        @JavascriptInterface
        public void showUrl(){
            myHandler.post(new Runnable() {
                @Override
                public void run() {
                    linear.setVisibility(View.VISIBLE);
                }
            });
        }

    }
}
