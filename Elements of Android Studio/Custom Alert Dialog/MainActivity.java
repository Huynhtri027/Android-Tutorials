package dailyquotes.kerem.webview;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

     WebView webView;
     Button button_facebook, button_youtube;
    FloatingActionButton floatingActionButton;

    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_facebook = (Button) findViewById(R.id.button_facebook);
        button_youtube = (Button) findViewById(R.id.button_youtube);
        floatingActionButton  =(FloatingActionButton)findViewById(R.id.floatingActionButton);
        button_facebook.setOnClickListener(this);
        button_youtube.setOnClickListener(this);
        //

        /*
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);

        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient());
        */

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();

            }
        });

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_facebook:
                Intent intent_facebook = new Intent(MainActivity.this, WebActivity.class);
                intent_facebook.putExtra("url","http://www.facebook.com");
                startActivity(intent_facebook);
                break;

            case R.id.button_youtube:
                Intent intent_youtube = new Intent(MainActivity.this, WebActivity.class);
                intent_youtube.putExtra("url","http://www.youtube.com");
                startActivity(intent_youtube);
                break;
        }

    }

    public void openDialog(){

        DialogAddWebsite dialogAddWebsite = new DialogAddWebsite();
        dialogAddWebsite.show(getSupportFragmentManager(), "dialog1");

    }
}
