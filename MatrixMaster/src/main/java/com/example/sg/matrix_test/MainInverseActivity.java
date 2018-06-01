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

public class MainInverseActivity extends AppCompatActivity {
    EditText editTextTaille;
    Button button;
    int taille = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inverse);

        editTextTaille = (EditText) findViewById(R.id.editTextTaille);

        TextView txt = (TextView) findViewById(R.id.textView9);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);
        editTextTaille.setTypeface(typeface);


        button = (Button) findViewById(R.id.buttonTaille);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextTaille.getText().toString().equals("")) {
                    Toast.makeText(MainInverseActivity.this, "Veuiller entrer une taille", Toast.LENGTH_SHORT).show();
                } else if (editTextTaille.getText().toString().equals("0")) {
                    Toast.makeText(MainInverseActivity.this, "Nombre Entrer Valide", Toast.LENGTH_SHORT).show();
                } else {
                    taille = Integer.parseInt(editTextTaille.getText().toString());
                    Intent intent = new Intent(MainInverseActivity.this, DataInverseActivity.class);
                    intent.putExtra("taille", taille);
                    startActivityForResult(intent, 0);
                }
            }
        });

    }
}
