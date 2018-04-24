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

import java.util.ArrayList;

import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;

public class AfficheNewtonActivity extends AppCompatActivity {
    TextView textViewAffResult,textViewCalc;
    ArrayList<String> dataX = new ArrayList<String>();
    ArrayList<String> dataY = new ArrayList<String>();
    EditText editTextCalc;
    Button button;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_newton);
        textViewAffResult = (TextView) findViewById(R.id.textViewAffResult);

        Intent intent = getIntent();
        dataX = intent.getStringArrayListExtra("datax");
        dataY = intent.getStringArrayListExtra("datay");
       // Toast.makeText(this,dataY.get(2),Toast.LENGTH_SHORT).show();
        Newton newton = new Newton(convertArrayListStringToDouble(dataX),convertArrayListStringToDouble(dataY));
        result = newton.polynom;
        textViewAffResult.setText("f(x) = "+result);
        result = funcmanager(result);
        textViewCalc = (TextView) findViewById(R.id.textViewCalc);
        textViewCalc.setText("");

        editTextCalc = (EditText) findViewById(R.id.editTextCalc);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        textViewAffResult.setTypeface(typeface);
        textViewCalc.setTypeface(typeface);
        editTextCalc.setTypeface(typeface);
        TextView txt = (TextView) findViewById(R.id.textView5);
        txt.setTypeface(typeface);

        button = (Button) findViewById(R.id.buttonCalc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    textViewCalc.setText(""+func(result,Double.parseDouble(editTextCalc.getText().toString())));
                } catch (TokenizerException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static double[] convertArrayListStringToDouble(ArrayList<String> list){
        double[] p = new double[list.size()];
        int ct=0;
        for( String s : list){
            p[ct]= Float.parseFloat(s);
            ct++;
        }

        return p;
    }

    public static Double func(String str, Double value) throws TokenizerException {
        AbstractTreeBuilder tree = new AbstractTreeBuilder(str);
        value = tree.getTree().getNumericResult(value);
        return value;

    }


    public static String funcmanager(String val){
        char c;
        for (int i = 0; i < val.length(); i++) {
            c = val.charAt(i);
            if (c == '-' && i == 0) {
                val = "0" + val;
            }
            if (c == '-' && i != 0) {
                if (val.charAt(i - 1) == '(') {
                    val = val.substring(0, i) + "0" + val.substring(i, val.length());
                }
            }
        }

        return val;
    }



}
