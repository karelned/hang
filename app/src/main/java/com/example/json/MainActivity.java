package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;

import com.android.volley.RequestQueue;

import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;


public class MainActivity extends AppCompatActivity {

    EditText mEditText;

    TextView mTextView;
    TextView mTextView2;
    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText);
        mTextView = findViewById(R.id.textSlovo);

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        mRequestQueue = new RequestQueue(cache, network );

        mRequestQueue.start();
    }

/*
    public void btnTranslate_Clicked(View view) {
        // string with user input
        String userInput = mEditText.getText().toString();

        Log.v("MYAPP",userInput);

        String url = "https://api.mymemory.translated.net/get?q="+userInput+"&langpair=en|it";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //mTextView.setText("Response: " + response.toString());
                        try {
                            JSONObject responseData = response.getJSONObject("responseData");
                            String translatedText = responseData.getString("translatedText");

                            mTextView.setText(translatedText);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        mRequestQueue.add(jsonObjectRequest);
    }
*/

    public void zacniHrat(View view) {
        Intent novaAktivita = new Intent(this, VyberOkruhy.class);
        startActivity(novaAktivita);
    }

    public void vypisScore(View view) {
        Intent novaAktivita = new Intent(this, ShowScoreActivity.class);
        startActivity(novaAktivita);
    }


    public void konec(View view) {
        finish();
    }
}
