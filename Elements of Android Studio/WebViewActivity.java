package keremapps.myfavoritewebsites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    private ProgressDialog progressDialog;

    private ImageView toolbar_image_close;
    private TextView toolbarText;

    @Override
    public void onBackPressed() {

        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            startActivity(new Intent(WebViewActivity.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        //
        webView = (WebView)findViewById(R.id.webView);
        //toolbar_image_close = (ImageView) findViewById(R.id.toolbar_image_close);
        toolbarText = (TextView) findViewById(R.id.toolbarText);
        //



        String receiveUrl = getIntent().getStringExtra("myUrl");
        loadWebsite(receiveUrl);

/*
        toolbar_image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WebViewActivity.this, MainActivity.class));
            }
        });
        */


    }


    private void loadWebsite(final String url){



        webView.getSettings().setJavaScriptEnabled(true);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);

        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);

        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                toolbarText.setText(""+url);

                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    view.loadUrl(url);

                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                if(progressDialog==null){
                    progressDialog = new ProgressDialog(WebViewActivity.this);
                    progressDialog.setMessage(""+R.string.webview_loading);
                    progressDialog.setTitle(""+R.string.webview_wait);
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                }

                super.onLoadResource(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
               progressDialog.dismiss();


                super.onPageFinished(view, url);
            }

        });

        webView.loadUrl(url);

    }



}
