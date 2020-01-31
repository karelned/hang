package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.json.R.id.pismeno;

public class activity_hra extends AppCompatActivity {

    TextView[] pismena = new TextView[12];
    int delka = 12;
    int okruh;
    String str="";
    int dobre = 0;
    int pocetChyb = 0;
    int body = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hra);

        okruh = getIntent().getIntExtra("VybranaMetoda", 1);

        pismena[0] = findViewById(R.id.p1);
        pismena[1] = findViewById(R.id.p2);
        pismena[2] = findViewById(R.id.p3);
        pismena[3] = findViewById(R.id.p4);
        pismena[4] = findViewById(R.id.p5);
        pismena[5] = findViewById(R.id.p6);
        pismena[6] = findViewById(R.id.p7);
        pismena[7] = findViewById(R.id.p8);
        pismena[8] = findViewById(R.id.p9);
        pismena[9] = findViewById(R.id.p10);
        pismena[10] = findViewById(R.id.p11);
        pismena[11] = findViewById(R.id.p12);



        novePismeno();
    }

    public void kontrola(View view) {
        for (int i = delka; i < 12; i++) {
            pismena[i].setVisibility(View.GONE);
        }

        EditText vyb = findViewById(R.id.pismeno);
        if (!(vyb.getText().toString().equals(""))) {
            boolean chyba = true;
            String pismn = vyb.getText().toString().toLowerCase();

            char tmp = pismn.charAt(0);
            for (int i = 0; i < delka; i++) {
                if (tmp == str.charAt(i)) {

                    if (pismena[i].getText().charAt(0)!=tmp) {
                        pismena[i].setText(Character.toString(tmp));
                        dobre = dobre + 1;
                        body = body + 1000;
                        chyba = false;
                    } else {
                        Toast.makeText(getApplicationContext(), "Toto písmeno si už vybral", Toast.LENGTH_LONG).show();
                    }
                }
            }
            if (chyba) {
                pocetChyb = pocetChyb + 1;
                body = body - 200;
                chyba();
            }
            if (dobre == delka) {
                novePismeno();
            }
            if (pocetChyb == 10) {
                Intent inte = new Intent(this, konec_hry.class);
                inte.putExtra("slovo", str);
                inte.putExtra("skore", Integer.toString(body));
                startActivity(inte);
                finish();
            }
            vyb.setText("");
        }
    }

    public void chyba() {
        ImageView imageView = findViewById(R.id.imageView);
        switch(pocetChyb) {
            case 1:
                imageView.setImageResource(R.mipmap.h1_foreground);
                break;
            case 2:
                imageView.setImageResource(R.mipmap.h2_foreground);
                break;
            case 3:
                imageView.setImageResource(R.mipmap.h3_foreground);
                break;
            case 4:
                imageView.setImageResource(R.mipmap.h4_foreground);
                break;
            case 5:
                imageView.setImageResource(R.mipmap.h5_foreground);
                break;
            case 6:
                imageView.setImageResource(R.mipmap.h6_foreground);
                break;
            case 7:
                imageView.setImageResource(R.mipmap.h7_foreground);
                break;
            case 8:
                imageView.setImageResource(R.mipmap.h8_foreground);
                break;
            case 9:
                imageView.setImageResource(R.mipmap.h9_foreground);
                break;
            case 10:
                imageView.setImageResource(R.mipmap.h10_foreground);
                break;
        }
    }

    public void novePismeno() {
        dobre = 0;
        for (int i = 0; i < 12; i++) {
            pismena[i].setVisibility(View.VISIBLE);
            pismena[i].setText("_");
        }

        String slovo;
        String[] poleInfo = new String[100];
        int delkaInfo = 0;
        Log.v("tag","výběr z okruhu:");
        Log.v("tag",Integer.toString(okruh));
        if (okruh == 1) {
            poleInfo = new String[]{"síť", "crack", "hacker", "firewall", "databáze", "počítač", "notebook", "klávesnice", "myš", "ram", "procesor", "java", "android", "windows", "linux", "ubuntu", "lubuntu", "algoritmus", "program", "bios", "hardware", "software", "monitor", "lan", "man", "wan", "ethernet", "proxy", "server", "chrome", "opera", "safari", "komprese", "dekomprese", "informace", "diagram", "kódování", "zdroj", "patice", "frekvence", "sektor", "odezva", "kontrast", "jas", "rozlišení", "skener", "tablet", "projektor", "cyklus", "podmínka", "pascal", "apple", "mac", "procedura"};
        }
        if (okruh == 2) {
            poleInfo = new String[]{"praha", "brno", "ostrava", "plzeň", "liberec", "olomouc", "pardubice", "havířov", "zlín", "kladno", "most", "karviná", "opava", "bruntál", "jihlava", "teplice", "kolín", "šumperk", "chomutov", "přerov", "prostějov", "třebíc", "tábor", "trinec", "znojmo", "příbram", "cheb", "orlová", "trutnov", "písek", "vsetín", "hodonín", "sokolov", "bohumín", "beroun", "jičín", "benešov"};
        }
        if (okruh == 3) {
            poleInfo = new String[]{"klokan", "opice", "zebra", "lama", "slon", "hroch", "velbloud", "nosorožec", "bažant", "medvěd", "slepice", "morče", "ovce", "prase", "koza", "kráva", "kohout", "králík", "zajíc", "tygr", "vlk", "veverka", "zába", "tulen", "ježek", "fredka", "křeček"};
        }
        if (okruh == 4) {
            poleInfo = new String[]{"audi", "bmw", "citroen", "dacia", "fiat", "ferrari", "kia", "honda", "škoda", "hyundai", "chevrolet", "jaguar", "jeep", "mazda", "mercedes", "mitsubishi", "nissan", "opel", "peugeot", "porsche", "renault", "rover", "saab", "seat", "subaru", "suzuki", "toyota", "volkswagen", "volvo", "bentley", "bugatti", "cadillac", "lada", "dodge", "infinity", "lancia", "lexus", "maybach", "pagani", "proton", "tatra", "trabant", "volha", "zastava"};
        }
        delkaInfo = poleInfo.length;
        Random ranInfo = new Random();
        int losInfo = ranInfo.nextInt(delkaInfo - 1);
        slovo = poleInfo[losInfo];
        Log.v("novej retezec",slovo);
        str=slovo;
        delka=str.length();

        for (int i = delka; i < 12; i++) {
            pismena[i].setVisibility(View.GONE);
        }
    }
}
