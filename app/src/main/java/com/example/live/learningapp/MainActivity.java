package com.example.live.learningapp;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sg.matrix_test.MainMatrixActivity;

import applications.linegraph.SupahActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_matrice,button_function,button_newton,button_lagrange;

    FloatingActionButton fab, fab1, fab2, fab3;
    LinearLayout fabLayout1, fabLayout2, fabLayout3;
    View fabBGLayout;
    boolean isFABOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);
        //fading probleme
        //getWindow().setExitTransition(null);
        //getWindow().setEnterTransition(null);


        button_matrice = (Button) findViewById(R.id.button_Matrices);
        button_function = (Button) findViewById(R.id.button_Fonctions);
        button_newton = (Button) findViewById((R.id.button_newton));
        button_lagrange = (Button) findViewById(R.id.button_lagrange);


        button_matrice.setOnClickListener(this);
        button_function.setOnClickListener(this);
        button_newton.setOnClickListener(this);
        button_lagrange.setOnClickListener(this);
        //custom font
        TextView txmatrice = (TextView) findViewById(R.id.TextMatrice);
        TextView txfonction = (TextView) findViewById(R.id.TextFonctions);
        TextView txlagrange = (TextView) findViewById(R.id.TextLagrange);
        TextView txNewton = (TextView) findViewById(R.id.TextNewton);
        TextView txfab1 = (TextView) findViewById(R.id.fab1_text);
        TextView txfab2 = (TextView) findViewById(R.id.fab2_text);
        TextView txfab3 = (TextView) findViewById(R.id.fab3_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        txmatrice.setTypeface(typeface);
        txfonction.setTypeface(typeface);
        txlagrange.setTypeface(typeface);
        txNewton.setTypeface(typeface);
        txfab1.setTypeface(typeface);
        txfab2.setTypeface(typeface);
        txfab3.setTypeface(typeface);


        fabLayout1 = (LinearLayout) findViewById(R.id.fabLayout1);
        fabLayout2 = (LinearLayout) findViewById(R.id.fabLayout2);
        fabLayout3 = (LinearLayout) findViewById(R.id.fabLayout3);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fabBGLayout = findViewById(R.id.fabBGLayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }
            }
        });

        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Matrices :
                Intent sharedintent_1 = new Intent(this, MainMatrixActivity.class);
                ActivityOptions options_1 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button_matrice, "buttonTransition");
                startActivity(sharedintent_1, options_1.toBundle());
                break;
            case R.id.button_Fonctions :
                Intent sharedintent_2 = new Intent(this, SupahActivity.class);
                ActivityOptions options_2 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button_function, "buttonTransition2");
                startActivity(sharedintent_2, options_2.toBundle());
                break;
            case R.id.button_lagrange:
                Intent sharedintent_3 = new Intent(this, MainLagrangeActivity.class);
                ActivityOptions options_3 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button_lagrange, "buttonTransition3");
                startActivity(sharedintent_3, options_3.toBundle());
                break;
            case R.id.button_newton:
                Intent sharedintent_4 = new Intent(this, MainNewtonActivity.class);
                ActivityOptions options_4 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button_newton, "buttonTransition4");
                startActivity(sharedintent_4, options_4.toBundle());
                break;

        }
    }

    private void showFABMenu() {
        isFABOpen = true;
        //to make the fab layout visible
        fabLayout1.setVisibility(View.VISIBLE);
        fabLayout2.setVisibility(View.VISIBLE);
        fabLayout3.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);
        //to hide the main menu buttons
        button_function.setVisibility(View.GONE);
        button_lagrange.setVisibility(View.GONE);
        button_matrice.setVisibility(View.GONE);
        button_newton.setVisibility(View.GONE);

        fab.animate().rotationBy(45);
        fabLayout1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabLayout2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        fabLayout3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));

        fabHandler();
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fabBGLayout.setVisibility(View.GONE);
        //to show main buttons
        button_function.setVisibility(View.VISIBLE);
        button_lagrange.setVisibility(View.VISIBLE);
        button_matrice.setVisibility(View.VISIBLE);
        button_newton.setVisibility(View.VISIBLE);

        fab.animate().rotationBy(-45);
        fabLayout1.animate().translationY(0);
        fabLayout2.animate().translationY(0);
        fabLayout3.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (!isFABOpen) {
                    fabLayout1.setVisibility(View.GONE);
                    fabLayout2.setVisibility(View.GONE);
                    fabLayout3.setVisibility(View.GONE);

                }

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    public void fabHandler() {
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFABOpen) {
                    Intent intent = new Intent(MainActivity.this, Help.class);
                    startActivity(intent);
                }
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFABOpen) {
                    Intent intent = new Intent(MainActivity.this, About_Us.class);
                    startActivity(intent);
                }
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFABOpen) {
                    Intent intent = new Intent(MainActivity.this, Documentation.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (isFABOpen) {
            closeFABMenu();
        } else {
            super.onBackPressed();
        }
    }
}
