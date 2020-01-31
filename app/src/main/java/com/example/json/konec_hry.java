package com.example.json;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class konec_hry extends AppCompatActivity {

    String slovo;
    String score;

    TextView textSlovo;
    TextView textScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konec_hry);

        slovo=getIntent().getStringExtra("slovo");
        score=getIntent().getStringExtra("skore");

        textSlovo = findViewById(R.id.textSlovo);
        textScore = findViewById(R.id.textScore);

        textSlovo.setText(slovo);
        textScore.setText(score);
    }

    public void ulozdopameti() {
        SharedPreferences preferences = getSharedPreferences("VYSLEDKY", MODE_PRIVATE);
        String soucasneskore = preferences.getString("VYSLEDKY", "");
        EditText editText = findViewById(R.id.editJmeno);
        String jmenoHrace = editText.getText().toString();

        SharedPreferences.Editor preeditor = preferences.edit();

        preeditor.putString("VYSLEDKY", soucasneskore + jmenoHrace + ": " + score + "\n");
        preeditor.apply();
        finish();
        Intent novaAktivita = new Intent(this, ShowScoreActivity.class);
        startActivity(novaAktivita);
        finish();
    }

    public void ulozscore(View v) {
        EditText editText = findViewById(R.id.editJmeno);
        String jmenoHrace = editText.getText().toString();

        if (!jmenoHrace.contains("\n") && jmenoHrace.length() >= 3) {
            AlertDialog.Builder nasdialog = new AlertDialog.Builder(this);

            nasdialog.setCancelable(true);

            nasdialog.setMessage("Chcete uložit výsledky hráče: " + jmenoHrace + " ?");

            nasdialog.setPositiveButton("Ano",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ulozdopameti();
                        }
                    });
            nasdialog.setNegativeButton("Ne",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Neuloženo", Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    });

            AlertDialog spustenidialogu = nasdialog.create();
            spustenidialogu.show();

        } else {
            Toast.makeText(getApplicationContext(), "Jméno musí mít alespoň 3 znaky !", Toast.LENGTH_LONG).show();
        }
    }

    public void konec(View view) {
        finish();
    }
}
