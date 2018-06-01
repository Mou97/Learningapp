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

public class MainDeterminantActivity extends AppCompatActivity {

    EditText rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_determinant);

        rows = (EditText) findViewById(R.id.rows);

        TextView txt = (TextView) findViewById(R.id.textView7);
        //custom font

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txt.setTypeface(typeface);
        rows.setTypeface(typeface);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rows.getText().toString().equals("")) {
                    Toast.makeText(MainDeterminantActivity.this, "Veuiller Ajouter l'Ordre de Votre Matrice", Toast.LENGTH_SHORT).show();
                } else {
                    opencActivityDataMatrix();
                }
            }
        });
    }

    public void opencActivityDataMatrix() {
        int row = Integer.parseInt(rows.getText().toString());

        Intent intent = new Intent(MainDeterminantActivity.this, DataDeterminantActivity.class);
        intent.putExtra("rows", row);

        startActivity(intent);
    }
}
