package com.example.sg.matrix_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMatrixActivity extends AppCompatActivity {

    Button butDetermiant, butInverse, butTranspose, butMulti, butAdd, butSous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matrix);

        butDetermiant = (Button) findViewById(R.id.butDeterminant);
        butDetermiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatrixActivity.this, MainDeterminantActivity.class);
                startActivity(intent);
            }
        });
        butInverse = (Button) findViewById(R.id.butInverse);
        butInverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatrixActivity.this, MainInverseActivity.class);
                startActivity(intent);
            }
        });

        butTranspose = (Button) findViewById(R.id.butTranspose);
        butTranspose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatrixActivity.this, MainTransposeActivity.class);
                startActivity(intent);
            }
        });

        butMulti = (Button) findViewById(R.id.butMulti);
        butMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatrixActivity.this, MainMultiplicationActivity.class);
                startActivity(intent);
            }
        });

        butAdd = (Button) findViewById(R.id.butAdd);
        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatrixActivity.this, MainAdditionActivity.class);
                startActivity(intent);
            }
        });

        butSous = (Button) findViewById(R.id.butSous);
        butSous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatrixActivity.this, MainSoustractionActivity.class);
                startActivity(intent);
            }
        });

    }
}
