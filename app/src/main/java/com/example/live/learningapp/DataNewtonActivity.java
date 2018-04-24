package com.example.live.learningapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class DataNewtonActivity extends AppCompatActivity {

    ArrayList<String> dataX = new ArrayList<String>();
    ArrayList<String> dataY = new ArrayList<String>();

    TextView datanfo;

    EditText editTextx;
    EditText editTexty;
    int n, ct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_newton);

        Intent intent = getIntent();
        n = intent.getIntExtra("nbrPoints", 0);

        datanfo = (TextView) findViewById(R.id.textViewInfo);
        datanfo.setText("");

        editTextx = (EditText) findViewById(R.id.editTextx);
        editTexty = (EditText) findViewById(R.id.editTexty);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        datanfo.setTypeface(typeface);
        editTextx.setTypeface(typeface);
        editTexty.setTypeface(typeface);

        Button button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextx.getText().toString().equals("") || editTexty.getText().toString().equals("")) {
                    Toast.makeText(DataNewtonActivity.this, "Veuiller remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else if (editTextx.getText().toString().equals("-") || editTextx.getText().toString().equals("+") || editTexty.getText().toString().equals("-") || editTexty.getText().toString().equals("+")) {
                    Toast.makeText(DataNewtonActivity.this, "Entrer Invalide", Toast.LENGTH_SHORT).show();
                } else if (dataX.contains(editTextx.getText().toString())) {
                    Toast.makeText(DataNewtonActivity.this, "Cette Abscisse existe déjà", Toast.LENGTH_SHORT).show();
                } else if (ct != n) {
                    dataX.add(editTextx.getText().toString());
                    dataY.add(editTexty.getText().toString());
                    datanfo.setText(datanfo.getText().toString() + "  (" + editTextx.getText().toString() + "," + editTexty.getText().toString() + ")");
                    editTextx.setText("");
                    editTexty.setText("");
                    ct++;
                }
                if (ct == n) {
                    openActivityFourthActivity();
                }
            }
        });

    }

    public void openActivityFourthActivity() {
        Intent intent = new Intent(DataNewtonActivity.this, AfficheNewtonActivity.class);
        intent.putExtra("datax", dataX);
        intent.putExtra("datay", dataY);
        DataNewtonActivity.this.finish();
        startActivity(intent);
    }
}
