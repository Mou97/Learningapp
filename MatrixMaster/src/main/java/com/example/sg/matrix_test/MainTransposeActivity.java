package com.example.sg.matrix_test;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainTransposeActivity extends AppCompatActivity {
    EditText editTextRows;
    EditText editTextColumns;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_transpose);

        editTextRows = (EditText) findViewById(R.id.editTextRows);
        editTextColumns = (EditText) findViewById(R.id.editTextColumns);

        TextView txt = (TextView) findViewById(R.id.textView6);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);
        editTextColumns.setTypeface(typeface);
        editTextRows.setTypeface(typeface);

        button = (Button) findViewById(R.id.buttonSuivant);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextRows.getText().toString().equals("")) {
                    Toast.makeText(MainTransposeActivity.this, "Veuiller Ajouter Le nombre de Ligne", Toast.LENGTH_SHORT).show();
                } else if (editTextColumns.getText().toString().equals("")) {
                    Toast.makeText(MainTransposeActivity.this, "Veuiller Ajouter Le nombre de Colonne", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainTransposeActivity.this, DataTransposeActivity.class);
                    intent.putExtra("rows", Integer.parseInt(editTextRows.getText().toString()));
                    intent.putExtra("columns", Integer.parseInt(editTextColumns.getText().toString()));
                    startActivity(intent);
                }
            }
        });

    }
}
