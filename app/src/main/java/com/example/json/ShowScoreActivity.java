package com.example.json;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        TextView textview = findViewById(R.id.hraci);
        SharedPreferences preferences = getSharedPreferences("VYSLEDKY", MODE_PRIVATE);
        String vysl = preferences.getString("VYSLEDKY", "");

        textview.setText(vysl);
    }

    public void konec(View view) {
        finish();
    }

    public void delet(View v) {
        AlertDialog.Builder nasDialog = new AlertDialog.Builder(this);
        nasDialog.setCancelable(true);
        nasDialog.setMessage("Opravdu chcete smazat veškeré zápisy dosažených bodů?");
        nasDialog.setPositiveButton("Ano",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences preferences = getSharedPreferences("VYSLEDKY", MODE_PRIVATE);
                        SharedPreferences.Editor preeditor = preferences.edit();
                        preeditor.putString("VYSLEDKY", "");
                        preeditor.apply();
                        finish();
                    }
                });
        nasDialog.setNegativeButton("Ne",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog spusteniDialogu = nasDialog.create();
        spusteniDialogu.show();
    }
}
