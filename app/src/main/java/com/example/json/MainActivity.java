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
