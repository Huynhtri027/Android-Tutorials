import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

   
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();

            }
        });

    }


  
    public void openDialog(){

        DialogAddWebsite dialogAddWebsite = new DialogAddWebsite();
        dialogAddWebsite.show(getSupportFragmentManager(), "dialog1");

    }
}
