package com.example.live.learningapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainNewtonActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_newton);
        editText = (EditText) findViewById(R.id.editTextPoints);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        editText.setTypeface(typeface);

        button = (Button) findViewById(R.id.buttonNew);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(MainNewtonActivity.this, "Veuiller Entrer Le Nombre de Points", Toast.LENGTH_SHORT).show();
                } else if (editText.getText().toString().equals("1") || editText.getText().toString().equals("0")) {
                    Toast.makeText(MainNewtonActivity.this, "Le Nombre de Points n'est pas Suffisant", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainNewtonActivity.this, DataNewtonActivity.class);
                    intent.putExtra("nbrPoints", Integer.parseInt(editText.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }
}
