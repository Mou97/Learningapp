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

public class DataMultiMatrice1Activity extends Activity {
    private List<EditText> editTextList = new ArrayList<EditText>();

    int rows, columns, rowsprime, columnsprime, rows2, columns2;
    ArrayList<String> data = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = (Intent) getIntent();
        rows = intent.getIntExtra("nbrRow1", 0);
        columns = intent.getIntExtra("nbrColumn1", 0);
        rows2 = intent.getIntExtra("nbrRow2", 0);
        columns2 = intent.getIntExtra("nbrColumn2", 0);

        rowsprime = rows;
        columnsprime = columns;

        LinearLayout linearLayout = new LinearLayout(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(FILL_PARENT, WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setBackgroundResource(R.drawable.background);

        int count = rows * columns;
        linearLayout.addView(tableLayout(count));
        linearLayout.addView(submitButton());
        linearLayout.setPadding(5, 2, 5, 2);
        setContentView(linearLayout);
        //Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();


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
                    Toast.makeText(DataMultiMatrice1Activity.this, "Veuiller remplir tous les champs", Toast.LENGTH_SHORT).show();
                    suivi = false;
                    break;
                }
            }
            if (suivi) {
                for (EditText e : editTextList) {
                    data.add(e.getText().toString());
                }
                Intent intent = new Intent(DataMultiMatrice1Activity.this, DataMultiMatrice2Activity.class);
                intent.putExtra("dataMatrice1", data);

                intent.putExtra("nbrRow1", rowsprime);
                intent.putExtra("nbrRow2", rows2);
                intent.putExtra("nbrColumn1", columnsprime);
                intent.putExtra("nbrColumn2", columns2);
                startActivity(intent);
                // Toast.makeText(DataDeterminantActivity.this,s,Toast.LENGTH_SHORT).show();}
            }
        }
    };

    // Using a TableLayout as it provides you with a neat ordering structure

    private TableLayout tableLayout(int count) {
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setStretchAllColumns(true);
        int noOfRows = count / columns;
        for (int i = 0; i < noOfRows; i++) {
            int rowId = columns * i;
            tableLayout.addView(createOneFullRow(rowId));
        }
        int individualCells = count % columns;
        tableLayout.addView(createLeftOverCells(individualCells, count));
        return tableLayout;
    }

    private TableRow createLeftOverCells(int individualCells, int count) {
        TableRow tableRow = new TableRow(this);
        tableRow.setPadding(0, 10, 0, 0);
        int rowId = count - individualCells;
        for (int i = 1; i <= individualCells; i++) {
            tableRow.addView(editText(String.valueOf(rowId + i)));
        }
        return tableRow;
    }

    private TableRow createOneFullRow(int rowId) {
        TableRow tableRow = new TableRow(this);
        tableRow.setPadding(0, 10, 0, 0);
        for (int i = 1; i <= columns; i++) {
            tableRow.addView(editText(String.valueOf(rowId + i)));
        }
        return tableRow;
    }

    private EditText editText(String hint) {
        EditText editText = new EditText(this);
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


}