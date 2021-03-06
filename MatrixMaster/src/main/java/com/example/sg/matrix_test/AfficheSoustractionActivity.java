package com.example.sg.matrix_test;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AfficheSoustractionActivity extends AppCompatActivity {
    int rows1, columns1;
    TextView textView;
    ArrayList<String> dataMat1 = new ArrayList<String>();
    ArrayList<String> dataMat2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_soustraction);
        textView = (TextView) findViewById(R.id.textView4);
        TextView txt = (TextView) findViewById(R.id.textView10);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        textView.setTypeface(typeface);
        txt.setTypeface(typeface);

        Intent intent = getIntent();
        rows1 = intent.getIntExtra("nbrRow", 0);
        columns1 = intent.getIntExtra("nbrColumn", 0);
        dataMat1 = intent.getStringArrayListExtra("dataMatrice1");
        dataMat2 = intent.getStringArrayListExtra("dataMatrice2");

        Matrix matrice1 = new Matrix(convertArrayToMatrix(dataMat1, rows1, columns1));
        Matrix matrice2 = new Matrix(convertArrayToMatrix(dataMat2, rows1, columns1));
        Matrix resultMulti = MatrixCalcule.subtract(matrice1, matrice2);


        textView.setTextSize(25);
        textView.setText("");
        for (int i = 0; i < resultMulti.getNrows(); i++) {
            for (int j = 0; j < resultMulti.getNcols(); j++) {
                textView.setText(textView.getText() + "   " + String.valueOf(round(resultMulti.getValueAt(i, j), 2)));
                textView.setTypeface(typeface);
            }
            textView.setText(textView.getText() + "\n");
        }


    }

    private double[][] convertArrayToMatrix(ArrayList<String> data, int row, int column) {
        int ct = 0;
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = Double.parseDouble(data.get(ct));
                ct++;
            }
        }
        return mat;
    }

    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
