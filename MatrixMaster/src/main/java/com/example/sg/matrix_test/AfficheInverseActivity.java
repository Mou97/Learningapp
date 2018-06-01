package com.example.sg.matrix_test;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class AfficheInverseActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<String>();
    TextView textView;
    int taille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_inverse);

        Intent intent = getIntent();
        data = intent.getStringArrayListExtra("data");
        taille = (int) Math.sqrt(data.size());
        textView = (TextView) findViewById(R.id.affMat);
        textView.setTextSize(25);
        //custom font
        TextView txt = (TextView) findViewById(R.id.textView10);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);

        int ct = 0;
        textView.setText("");

        for (String r : data) {
            if (ct == taille) {
                ct = 0;
                textView.setText(textView.getText() + "\n");
                textView.setTypeface(typeface);
            }
            textView.setText(textView.getText() + "   " + String.valueOf(round(Double.parseDouble(r), 2)));
            ct++;
        }

    }

    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
