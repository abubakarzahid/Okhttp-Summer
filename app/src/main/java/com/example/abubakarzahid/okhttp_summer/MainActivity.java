package com.example.abubakarzahid.okhttp_summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.security.PrivateKey;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private String url = "https://api.myjson.com/bins/15z271";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnsendrequest = (Button) findViewById(R.id.btnsendrequest);
        EditText etjson = (EditText)findViewById(R.id.etjson);


        btnsendrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // initialize the http client
              OkHttpClient  okHttpClient = new OkHttpClient();
                // inintialize the request
                Request request = new Request().Builder.url(url).build();


            }
        });
    }
}
