package com.example.sg.matrix_test;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AfficheDeterminantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_determinant);
        Intent intent = getIntent();
        String det = (String) intent.getStringExtra("result");
        TextView result = (TextView) findViewById(R.id.resulted);
        //custom font
        TextView txt = (TextView) findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);

        det = String.valueOf(round(Double.parseDouble(det), 2));
        result.setTextSize(20);
        result.setText(det);
        //custom font
        result.setTypeface(typeface);


    }


    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
