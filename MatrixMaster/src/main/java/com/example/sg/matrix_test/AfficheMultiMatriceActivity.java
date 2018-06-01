package com.example.sg.matrix_test;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AfficheMultiMatriceActivity extends AppCompatActivity {
    int rows1, columns1, rows2, columns2;
    TextView textView;
    ArrayList<String> dataMat1 = new ArrayList<String>();
    ArrayList<String> dataMat2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_multi_matrice);

        textView = (TextView) findViewById(R.id.textView4);
        TextView txt = (TextView) findViewById(R.id.textView10);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        textView.setTypeface(typeface);
        txt.setTypeface(typeface);

        Intent intent = getIntent();
        rows2 = intent.getIntExtra("nbrRow2", 0);
        columns2 = intent.getIntExtra("nbrColumn2", 0);
        rows1 = intent.getIntExtra("nbrRow1", 0);
        columns1 = intent.getIntExtra("nbrColumn1", 0);
        dataMat1 = intent.getStringArrayListExtra("dataMatrice1");
        dataMat2 = intent.getStringArrayListExtra("dataMatrice2");

        Matrix matrice1 = new Matrix(convertArrayToMatrix(dataMat1, rows1, columns1));
        Matrix matrice2 = new Matrix(convertArrayToMatrix(dataMat2, rows2, columns2));
        Matrix resultMulti = MatrixCalcule.multiply(matrice1, matrice2);

        //Toast.makeText(AfficheMultiMatriceActivity.this,String.valueOf(matrice2.getValueAt(0,0))+" "+String.valueOf(matrice2.getValueAt(1,0)),Toast.LENGTH_SHORT).show();
        //Toast.makeText(AfficheMultiMatriceActivity.this,dataMat2.get(0)+" "+dataMat2.get(1),Toast.LENGTH_SHORT).show();

        textView.setText("");
        for (int i = 0; i < resultMulti.getNrows(); i++) {
            for (int j = 0; j < resultMulti.getNcols(); j++) {
                textView.setText(textView.getText() + "   " + String.valueOf(round(resultMulti.getValueAt(i, j), 2)));
            }
            textView.setText(textView.getText() + "\n");
        }


    }

    private double[][] convertArrayToMatrix(ArrayList<String> data, int row, int column) {
        //int i, j;
        //i = j = 0;
        int ct = 0;
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = Double.parseDouble(data.get(ct));
                ct++;
            }
        }
        /*for (String s : data) {
            mat[i][j] = Double.parseDouble(s);
            i++;
            if (i == row) {
                i = 0;
                j++;
            }
            if (i == row && j == column) {
                break;
            }
        }*/
        return mat;
    }

    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
