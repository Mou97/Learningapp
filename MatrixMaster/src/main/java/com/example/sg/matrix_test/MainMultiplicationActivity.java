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

public class MainMultiplicationActivity extends AppCompatActivity {

    Button button;
    EditText nbrRow1, nbrRow2, nbrColumn1, nbrColumn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_multiplication);
        nbrRow1 = (EditText) findViewById(R.id.editText3);
        nbrRow2 = (EditText) findViewById(R.id.editText4);
        nbrColumn1 = (EditText) findViewById(R.id.editText5);
        nbrColumn2 = (EditText) findViewById(R.id.editText6);

        TextView txt = (TextView) findViewById(R.id.textView2);
        TextView txt2 = (TextView) findViewById(R.id.textView3);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);
        txt2.setTypeface(typeface);
        nbrRow1.setTypeface(typeface);
        nbrRow2.setTypeface(typeface);
        nbrColumn1.setTypeface(typeface);
        nbrColumn2.setTypeface(typeface);

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nbrRow1.getText().toString().equals("") || nbrColumn1.getText().toString().equals("") || nbrRow2.getText().toString().equals("") || nbrColumn2.getText().toString().equals("")) {
                    Toast.makeText(MainMultiplicationActivity.this, "Veuiller remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else if (nbrRow1.getText().toString().equals("0") || nbrColumn1.getText().toString().equals("0") || nbrRow2.getText().toString().equals("0") || nbrColumn2.getText().toString().equals("0")) {
                    Toast.makeText(MainMultiplicationActivity.this, "Nombre Entrer Invalide", Toast.LENGTH_SHORT).show();
                } else if (!nbrColumn1.getText().toString().equals(nbrRow2.getText().toString())) {
                    Toast.makeText(MainMultiplicationActivity.this, "L'ordre des deux matrices n'est pas valide", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainMultiplicationActivity.this, DataMultiMatrice1Activity.class);
                    intent.putExtra("nbrRow1", Integer.parseInt(nbrRow1.getText().toString()));
                    intent.putExtra("nbrRow2", Integer.parseInt(nbrRow2.getText().toString()));
                    intent.putExtra("nbrColumn1", Integer.parseInt(nbrColumn1.getText().toString()));
                    intent.putExtra("nbrColumn2", Integer.parseInt(nbrColumn2.getText().toString()));
                    startActivity(intent);

                }
            }

        });

    }
}
