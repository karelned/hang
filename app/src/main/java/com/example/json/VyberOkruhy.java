package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.String;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class VyberOkruhy extends AppCompatActivity {

    int vyber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vyber_okruhy);
    }


    public void start(View view) {
        RadioGroup radioGroup = findViewById(R.id.rb);
        int ID = radioGroup.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(ID);

        String nazev = radioButton.getText().toString();
        Toast.makeText(getApplicationContext(), "Vybrán okruh: " + nazev, Toast.LENGTH_LONG).show();

        if (nazev.equals("Informatika")) vyber = 1;
        if (nazev.equals("Mesta")) vyber = 2;
        if (nazev.equals("Zvirata")) vyber = 3;
        if (nazev.equals("Auta")) vyber = 4;

        Intent inte = new Intent(this, activity_hra.class);
        inte.putExtra("VybranaMetoda", vyber);
        startActivity(inte);
        finish();
    }
}
