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

public class MainAdditionActivity extends AppCompatActivity {
    Button button;
    EditText rows, columns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_addition);

        rows = (EditText) findViewById(R.id.editText7);
        columns = (EditText) findViewById(R.id.editText8);

        TextView txt = (TextView) findViewById(R.id.textView);
        //custom font

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);
        rows.setTypeface(typeface);
        columns.setTypeface(typeface);

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rows.getText().toString().equals("") || columns.getText().toString().equals("")) {
                    Toast.makeText(MainAdditionActivity.this, "Veuiller remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(rows.getText().toString()) == 0 || Integer.parseInt(columns.getText().toString()) == 0) {
                    Toast.makeText(MainAdditionActivity.this, "Valeur Enter Invalide", Toast.LENGTH_SHORT);
                } else {
                    Intent intent = new Intent(MainAdditionActivity.this, DataAddMatrice1Activity.class);
                    intent.putExtra("rows", Integer.parseInt(rows.getText().toString()));
                    intent.putExtra("columns", Integer.parseInt(columns.getText().toString()));
                    startActivity(intent);

                }
            }
        });
    }
}
