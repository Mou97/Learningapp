package com.example.live.learningapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_matrice,button_function,button_newton,button_lagrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_matrice = (Button) findViewById(R.id.button_Matrices);
        button_function = (Button) findViewById(R.id.button_Fonctions);
        button_newton = (Button) findViewById((R.id.button_newton));
        button_lagrange = (Button) findViewById(R.id.button_lagrange);


        button_matrice.setOnClickListener(this);
        button_function.setOnClickListener(this);
        button_newton.setOnClickListener(this);
        button_lagrange.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Matrices :
                Intent sharedintent_1 = new Intent(MainActivity.this, MatricesMenu.class);
                ActivityOptions options_1 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button_matrice, "buttonTransition");
                startActivity(sharedintent_1, options_1.toBundle());
                break;
            case R.id.button_Fonctions :

                Intent sharedintent_2 = new Intent(MainActivity.this, FunctionsMenu.class);
                ActivityOptions options_2 = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button_function, "buttonTransition2");
                startActivity(sharedintent_2, options_2.toBundle());
                break;
            case R.id.button_newton:
                Toast.makeText(this, "button newton clicked ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_lagrange:
                Toast.makeText(this, "Button lagrange clicked", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
