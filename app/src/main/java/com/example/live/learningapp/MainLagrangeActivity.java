package com.example.live.learningapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainLagrangeActivity extends AppCompatActivity {


    private EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lagrange);

        //fading probleme
        //getWindow().setExitTransition(null);
        //getWindow().setEnterTransition(null);

        editText1 = (EditText) findViewById(R.id.edittextNbrPoint);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        editText1.setTypeface(typeface);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(MainLagrangeActivity.this, "Veuiller Entrer Le Nombre de Points", Toast.LENGTH_SHORT).show();
                } else if (editText1.getText().toString().equals("0")
                        || editText1.getText().toString().equals("1")) {
                    Toast.makeText(MainLagrangeActivity.this, "Le Nombre de Points n'est pas Suffisant", Toast.LENGTH_SHORT).show();
                } else {
                    openActivityDonnee();
                }
            }
        });

    }

    public void openActivityDonnee(){

        int number = Integer.parseInt(editText1.getText().toString());

        Intent intent = new Intent (MainLagrangeActivity.this, DataLagrangeActivity.class);
        intent.putExtra("number",number);

        startActivityForResult(intent,1);
    }
}
