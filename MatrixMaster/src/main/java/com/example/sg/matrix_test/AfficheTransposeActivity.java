package com.example.sg.matrix_test;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AfficheTransposeActivity extends AppCompatActivity {
    int rows, columns;
    ArrayList<String> data = new ArrayList<String>();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_transpose);
        Intent intent = getIntent();
        rows = intent.getIntExtra("rows", 0);
        columns = intent.getIntExtra("columns", 0);
        data = intent.getStringArrayListExtra("result");

        textView = (TextView) findViewById(R.id.textViewTranspose);
        TextView txt = (TextView) findViewById(R.id.textView10);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);

        textView.setText("");
        textView.setTextSize(25);
        int ct = 0;

        double[][] mat = convertArrayToMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                textView.setText(textView.getText() + "   " + String.valueOf(round(mat[i][j], 2)));
                textView.setTypeface(typeface);
            }
            textView.setText(textView.getText() + "\n");
        }


    }

    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private double[][] convertArrayToMatrix() {
        int i, j;
        i = j = 0;
        double[][] mat = new double[rows][columns];
        for (String s : data) {
            mat[i][j] = Double.parseDouble(s);
            i++;
            if (i == rows) {
                i = 0;
                j++;
            }
            if (i == rows && j == columns) {
                break;
            }
        }
        return mat;
    }


}
