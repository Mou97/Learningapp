package com.example.live.learningapp;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
import java.util.Scanner;

import static java.lang.System.exit;

public class Newton {
    public double[] xs;
    public double[] ys;
    private double[] X;
    private double[] f;
    public int max;
    private int diff;
    private int somme;
    public String polynom;


    public Newton(double[] datax,double[] datay){

        xs = datax;
        ys = datay;
        max = datax.length;
        double[] fs = new double[max];
        somme = 0;
        for (int i=0; i < max; i++) {
            somme += i;
        }
        X = new double[somme];
        f = new double[somme];
        getX();
        first_f();
        second_f();
        fs[0] = ys[0];
        int d  = max-1;
        diff = 0;
        for (int i = 1; i < max; i++) {
            fs[i] = f[diff];
            diff += d;
            d--;
        }
        // Initialize result array
        double[] result = new double[xs.length];
        for (int i = 0; i < xs.length; ++i) {
            result[i] = 0.0;
        }

        for (int i = 0; i < xs.length; ++i) {
            // 'poly' has a degree 'i'. We use 'i - 1' because only terms
            // from 0 to 'i - 1' are used
            double[] poly = getPoly(xs, i - 1);

            // Now add to result, do not forget to multiply by the divided
            // difference !
            for (int j = 0; j < poly.length; ++j) {
                result[j] += poly[j] * fs[i];
            }
        }
        polynom =  convertToPolynomial(result);
    }
    private void getX() {
        diff = 1;
        int j=0;
        while ((max - diff) > 0 ){
            for ( int i=0 ;i< max-diff;i++, j++) {
                X[j] = xs[i+diff] - xs[i];
            }
            diff++;
        }
    }
    private void first_f() {
        for (int i=0 ;i< max-1;i++) {
            f[i] = (ys[i+1] - ys[i])/X[i];
        }
    }
    private void second_f() {
        diff = max - 2;
        int j = max-1;
        while (diff > 0) {
            for(int i=1;i<=diff;i++,j++) {
                f[j] = (f[j-diff] - f[j-diff-1])/X[j];

            }
            diff--;
        }

    }
    private static String convertToPolynomial(double [] coefs) {
        String s;
        if (coefs[0] != 0)
            s = Double.toString(coefs[0]);
        else s ="";
        int degree = coefs.length;
        for (int i = 1; i < degree; i ++) {
            if (coefs[i] > 0 && s != "") {
                s += "  +  ";
            }
            if (coefs[i] < 0) {
                coefs[i]*= -1;
                s += "  -  ";
            }
            if (coefs[i] != 0) {
                if (i == 1) {
                    s += coefs[i]+"x";
                }
                else if (i > 1) {
                    if (coefs[i] != 1)
                        s += coefs[i] + "x^" + i;
                    else s += "x^" + i;
                }
            }

        }
        return  s;
    }
    private static double[] getPoly(double[] xs, int i) {
        // Start poly: 1.0, neutral value for multiplication
        double[] coefs = {1.0};

        // Accumulate xs of products
        for (int j = 0; j <= i; ++j) {
            // 'coefsLocal' represent polynom of 1st degree (x - xs[j])
            double[] coefsLocal = {-xs[j], 1.0};
            coefs = getPolyProduct(coefs, coefsLocal);
        }

        return coefs;
    }
    private static double[] getPolyProduct(double[] coefs1, double[] coefs2) {
        // Get lengths and degree
        int s1 = coefs1.length - 1;
        int s2 = coefs2.length - 1;
        int degree = s1 + s2;

        // Initialize polynom resulting from product, with null xs
        double[] coefsProduct = new double[degree + 1];
        for (int k = 0; k <= degree; ++k) {
            coefsProduct[k] = 0.0;
        }

        // Compute products
        for (int i = 0; i <= s1; ++i)   {
            for (int j = 0; j <= s2; ++j)   {
                coefsProduct[i + j] += coefs1[i] * coefs2[j];
            }
        }
        return coefsProduct;
    }
}

