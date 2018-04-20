package com.example.live.learningapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;

public class Grange_Result_Activity extends AppCompatActivity {

    ArrayList<String> dataXs = new ArrayList<String>();
    ArrayList<String> dataYs = new ArrayList<String>();

    float[] dataX;
    float[] dataY;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grange__result_);

        Intent intent = getIntent();
        dataXs = intent.getStringArrayListExtra("tabx");
        dataYs = intent.getStringArrayListExtra("taby");

        dataX = convertArrayListStringToDouble(dataXs);
        dataY = convertArrayListStringToDouble(dataYs);

        String resultS = convertToPolynomial(getPolynomial(dataX, dataY));

        result = (TextView) findViewById(R.id.result);
        result.setText(resultS);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        result.setTypeface(typeface);
    }


    public static String funcmanager(String val) {
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

    public static Double func(String str, Double value) throws TokenizerException {
        AbstractTreeBuilder tree = new AbstractTreeBuilder(str);
        value = tree.getTree().getNumericResult(value);
        return value;

    }

    public static float[] convertArrayListStringToDouble(ArrayList<String> list) {
        float[] p = new float[list.size()];
        int ct = 0;
        for (String s : list) {
            p[ct] = Float.parseFloat(s);
            ct++;
        }

        return p;
    }

    public static float[] addPolynomials(float[] a, float[] b) {
        int degree = a.length;
        float[] c = new float[degree];
        for (int i = 0; i < degree; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static float[] getPolynomial(float[] xs, float[] ys) {
        int degree = xs.length;
        float[][] deltas = new float[degree][degree];
        float[] result = new float[degree];

        for (int i = 0; i < degree; i++) {
            deltas[i] = getDeltaPolynomial(xs, i);
        }

        for (int i = 0; i < degree; i++) {
            result = addPolynomials(result, scalePoly(deltas[i], ys[i]));
        }

        return result;
    }

    public static float[] multiplyPolynomials(float[] a, float[] b) {
        int degA = a.length;
        int degB = b.length;
        float[] result = new float[degA + degB - 1];
        for (int i = 0; i < degA; i++) {
            for (int j = 0; j < degB; j++) {
                result[i + j] += a[i] * b[j];
            }
        }
        return result;
    }

    public static float[] getDeltaPolynomial(float[] xs, int xpos) {
        float[] poly = {1};
        float denom = 1;
        for (int i = 0; i < xs.length; i++) {
            if (i != xpos) {
                float[] currentTerm = {1, -xs[i]};
                denom *= xs[xpos] - xs[i];
                poly = multiplyPolynomials(poly, currentTerm);
            }
        }
        return scalePoly(poly, 1 / denom);
    }

    public static float[] scalePoly(float[] a, float k) {
        float[] b = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * k;
        }
        return b;
    }

    public static String convertToPolynomial(float[] coefs) {
        String s = "";
        int degree = coefs.length;
        for (int i = 0; i < degree; i++) {
            if ((coefs[i] * 100 - (int) (coefs[i] * 100)) > 0.50)
                coefs[i] = ((int) (coefs[i] * 100) + 1) / 100.f;
            else coefs[i] = ((int) (coefs[i] * 100)) / 100.f;
            if (coefs[i] > 0 && s != "") {
                s += "  +  ";
            }
            if (coefs[i] < 0) {
                coefs[i] *= -1;
                s += "  -  ";
            }
            if (coefs[i] != 0) {
                if (coefs[i] == (int) coefs[i]) {
                    if (coefs[i] != 1 || (coefs[i] == 1 && degree - i - 1 == 0)) {
                        s += Float.toString((float) coefs[i]);
                    }
                } else {
                    s += Float.toString(coefs[i]);
                }
            }
            if (coefs[i] != 0) {
                if (degree - i - 1 == 1) {
                    s += "x";
                } else if (degree - i - 1 > 1) {
                    s += "x^" + (degree - i - 1);
                }
            }

        }
        return "f(x) = " + s;
    }
}
