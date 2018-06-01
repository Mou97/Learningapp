package com.example.sg.matrix_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

public class DataInverseActivity extends Activity {
    private List<EditText> editTextList = new ArrayList<EditText>();

    int taille, tailleprime;
    ArrayList<String> data = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = (Intent) getIntent();

        taille = intent.getIntExtra("taille", 0);
        tailleprime = taille;


        LinearLayout linearLayout = new LinearLayout(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(FILL_PARENT, WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setBackgroundResource(R.drawable.background);

        int count = taille * taille;
        linearLayout.addView(tableLayout(count));
        linearLayout.addView(submitButton());
        linearLayout.setPadding(5, 2, 5, 2);
        setContentView(linearLayout);


    }

    private Button submitButton() {
        Button button = new Button(this);
        //editing the background of the button created
        Drawable butbackground = (Drawable) getResources().getDrawable(R.drawable.icon_suivant);
        button.setBackground(butbackground);
        button.setOnClickListener(submitListener);
        button.setLayoutParams(new ViewGroup.LayoutParams(660, 210));
        return button;
    }

    // Access the value of the EditText

    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View view) {
            Boolean suivi = true;
            for (EditText e : editTextList) {
                if (e.getText().toString().equals("")) {
                    Toast.makeText(DataInverseActivity.this, "Veuiller remplir tous les champs", Toast.LENGTH_SHORT).show();
                    suivi = false;
                    break;
                }
            }
            if (suivi) {
                Matrix k = new Matrix(convertArrayToMatrix(tailleprime));
                if (MatrixCalcule.determinant(k) != 0.0) {
                    data = convertMatrixtoArray();
                    // Toast.makeText(DataInverseActivity.this, "hee", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DataInverseActivity.this, AfficheInverseActivity.class);
                    intent.putExtra("data", data);
                    startActivity(intent);

                } else {
                    Toast.makeText(DataInverseActivity.this, "Cette Matrice n'est pas inversible", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };


    // Using a TableLayout as it provides you with a neat ordering structure

    private TableLayout tableLayout(int count) {
        TableLayout tableLayout = new TableLayout(DataInverseActivity.this);
        tableLayout.setStretchAllColumns(true);
        int noOfRows = count / taille;
        for (int i = 0; i < noOfRows; i++) {
            int rowId = taille * i;
            tableLayout.addView(createOneFullRow(rowId));
        }
        int individualCells = count % taille;
        tableLayout.addView(createLeftOverCells(individualCells, count));
        return tableLayout;
    }

    private TableRow createLeftOverCells(int individualCells, int count) {
        TableRow tableRow = new TableRow(DataInverseActivity.this);
        tableRow.setPadding(0, 10, 0, 0);
        int rowId = count - individualCells;
        for (int i = 1; i <= individualCells; i++) {
            tableRow.addView(editText(String.valueOf(rowId + i)));
        }
        return tableRow;
    }

    private TableRow createOneFullRow(int rowId) {
        TableRow tableRow = new TableRow(DataInverseActivity.this);
        tableRow.setPadding(0, 10, 0, 0);
        for (int i = 1; i <= taille; i++) {
            tableRow.addView(editText(String.valueOf(rowId + i)));
        }
        return tableRow;
    }

    private EditText editText(String hint) {
        EditText editText = new EditText(DataInverseActivity.this);
        editText.setId(Integer.valueOf(hint));
        editText.setHint(hint);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        editText.setTypeface(typeface);
        editText.setTextColor(Color.parseColor("#f2f1f2"));
        editText.setHintTextColor(Color.parseColor("#f2f1f2"));
        editTextList.add(editText);
        return editText;
    }

    public Matrix calculInverse() {
        double[][] mat = convertArrayToMatrix(tailleprime);
        Matrix data = new Matrix(mat);
        Matrix result = MatrixCalcule.inverse(data);
        return result;
    }

    private double[][] convertArrayToMatrix(int taille) {
        int i, j;
        i = j = 0;
        double[][] mat = new double[taille][taille];
        for (EditText editText : editTextList) {
            mat[i][j] = Double.parseDouble(editText.getText().toString());
            i++;
            if (i == taille) {
                i = 0;
                j++;
            }
            if (i == tailleprime && j == tailleprime) {
                break;
            }
        }
        return mat;
    }

    private ArrayList<String> convertMatrixtoArray() {
        ArrayList<String> data = new ArrayList<String>();
        Matrix inv = calculInverse();
        for (int i = 0; i < tailleprime; i++) {
            for (int j = 0; j < tailleprime; j++) {
                data.add(String.valueOf(inv.getValueAt(j, i)));
            }
        }
        return data;
    }
}