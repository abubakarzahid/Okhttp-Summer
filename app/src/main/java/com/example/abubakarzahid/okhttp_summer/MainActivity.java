package com.example.abubakarzahid.okhttp_summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private  Button getbtn;
    private TextView result;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.txtresponse);
        getbtn = (Button)findViewById(R.id.btnrequest);

        getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWebservice();
            }
        });
        client = new OkHttpClient();
    }
    private void getWebservice(){
        Request request = new Request.Builder()
                .url("https://api.myjson.com/bins/10m5nz")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText("failure");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response)  {

              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          result.setText(response.body().string());
                      } catch (IOException ioe){
                          result.setText("Error getting messoage");
                      }
                  }
              });
            }
        });


    }
}
