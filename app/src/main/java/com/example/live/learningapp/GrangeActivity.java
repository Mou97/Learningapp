package com.example.live.learningapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GrangeActivity extends AppCompatActivity {

    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grange);

        editText1 = (EditText) findViewById(R.id.edittextNbrPoint);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        editText1.setTypeface(typeface);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(GrangeActivity.this, "Veuiller inserer un nombre", Toast.LENGTH_SHORT).show();
                } else if (editText1.getText().toString().equals("0")
                        || editText1.getText().toString().equals("1")) {
                    Toast.makeText(GrangeActivity.this, "Veuiller entrer un nombre > que 1", Toast.LENGTH_SHORT).show();
                } else {
                    openActivityDonnee();
                }
            }
        });
    }

    public void openActivityDonnee() {

        int number = Integer.parseInt(editText1.getText().toString());

        Intent intent = new Intent(GrangeActivity.this, Grange_Data_Activity.class);
        intent.putExtra("number", number);

        startActivityForResult(intent, 1);
    }
}
