package applications.linegraph;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;


public class FirstActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText;
    private boolean validate = false;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonaddi;
    Button buttonsoustra;
    Button buttondiv;
    Button buttonmulti;
    Button buttonC;
    Button buttonPoint;
    Button buttoncos;
    Button buttonacos;
    Button buttonsin;
    Button buttonasin;
    Button buttontang;
    Button buttonatan;
    Button buttonacotang;
    Button buttoncotang;
    Button buttonexp, buttonln;
    Button buttonPrenthesegauche, buttoncarre;
    Button buttonpuissance;
    Button buttonPrenthesedroite;
    Button buttonpi, buttonE;
    Button buttonfunct, buttonsupprimer, buttonvarx;
    Button buttonsqrt;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        editText1 = (EditText) findViewById(R.id.edittext1);
        editText2 = (EditText) findViewById(R.id.edittext2);
        editText = (EditText) findViewById(R.id.edittext3);
        //hide soft keyboard  :
        disableButtonClick(editText);


        //
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        editText1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editText2.setImeOptions(EditorInfo.IME_ACTION_DONE);


        Button button = (Button) findViewById(R.id.button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                    Toast.makeText(FirstActivity.this, "Veuillez inserer un numéro", Toast.LENGTH_SHORT).show();
                } else if (editText.getText().toString().equals("")) {
                    Toast.makeText(FirstActivity.this, "Veuillez inserer une fonction", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        openActivity2();
                    } catch (Exception e) {
                        Drawable warning = (Drawable) getResources().getDrawable(R.drawable.icon_warning);
                        warning.setBounds(0, 0, warning.getIntrinsicWidth(), warning.getIntrinsicHeight());
                        editText.setError("Format non-valide", warning);
                    }
                    if (validate) {
                        Toast.makeText(FirstActivity.this, "invalide", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                return true;
            }
        });


        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonaddi = (Button) findViewById(R.id.buttonaddi);
        buttonsoustra = (Button) findViewById(R.id.buttonsoustra);
        buttondiv = (Button) findViewById(R.id.buttondiv);
        buttonmulti = (Button) findViewById(R.id.buttonmulti);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttoncos = (Button) findViewById(R.id.buttoncos);
        buttonacos = (Button) findViewById(R.id.buttonacos);
        buttonsin = (Button) findViewById(R.id.buttonSin);
        buttonasin = (Button) findViewById(R.id.buttonasin);
        buttontang = (Button) findViewById(R.id.buttontang);
        buttonatan = (Button) findViewById(R.id.buttonatan);
        buttoncotang = (Button) findViewById(R.id.buttoncotang);
        buttonacotang = (Button) findViewById(R.id.buttonaacotang);
        buttonpi = (Button) findViewById(R.id.buttonpi);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonPrenthesegauche = (Button) findViewById(R.id.buttonPrenthesegauche);
        buttonPrenthesedroite = (Button) findViewById(R.id.buttonPrenthesedroite);
        buttonfunct = (Button) findViewById(R.id.buttonfunct);
        buttonsupprimer = (Button) findViewById(R.id.buttonsupprimer);
        buttonexp = (Button) findViewById(R.id.buttonExp);
        buttonln = (Button) findViewById(R.id.buttonLn);
        buttonpuissance = (Button) findViewById(R.id.buttonpuissance);
        buttoncarre = (Button) findViewById(R.id.buttoncarre);
        buttonvarx = (Button) findViewById(R.id.buttonvarx);
        buttonsqrt = (Button) findViewById(R.id.buttonsqrt);


        //On attribue un écouteur d'évènement à tous les boutons


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "0"));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "1"));

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "2"));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "3"));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "4"));
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "5"));
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "7"));
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "6"));
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "8"));
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "9"));
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "."));
            }
        });
        buttonaddi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "+"));
            }
        });
        buttonsoustra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "-"));
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "."));
            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "/"));
            }
        });
        buttonmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "*"));
            }
        });
        buttonsupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() != 0) {
                    editText.setText(editText.getText().delete(editText.getText().length() - 1, editText.getText().length()));
                }
            }
        });
        buttoncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "cos("));
            }
        });
        buttonacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "acos("));
            }
        });
        buttonsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "sin("));
            }
        });
        buttonasin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "asin("));
            }
        });
        buttontang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "tang("));
            }
        });
        buttonatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "atan("));
            }
        });
        buttoncotang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "cotan("));
            }
        });
        buttonacotang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "acotan("));
            }
        });
        buttoncarre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "^2"));
            }
        });
        buttonpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "pi"));
            }
        });
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "e"));
            }
        });
        buttonPrenthesegauche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "("));
            }
        });
        buttonPrenthesedroite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), ")"));
            }
        });

        buttonsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "sqrt("));
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        buttonvarx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "x"));
            }
        });
        buttonexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "exp("));
            }
        });
        buttonln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "log("));
            }
        });
        buttonpuissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().insert(editText.getText().length(), "^"));
            }
        });

    }


    public void openActivity2() throws TokenizerException {


        Double number1 = Double.parseDouble(editText1.getText().toString());
        Double number2 = Double.parseDouble(editText2.getText().toString());
        String text = editText.getText().toString();

        Intent intent = new Intent(FirstActivity.this, GraphActivity.class);
        intent.putExtra("number1", number1);
        intent.putExtra("number2", number2);
        intent.putExtra("text", text);

        if (Double.isInfinite(func(text, number1)) || Double.isNaN(func(text, number1)) ||
                Double.isInfinite(func(text, number2)) || Double.isNaN(func(text, number2))) {
            Toast.makeText(FirstActivity.this, "Invalide", Toast.LENGTH_SHORT).show();
            validate = true;
        } else {
            double result = func(text, number1);
            startActivity(intent);
        }
    }

    public static String funcmanager(String val) {
        val = val.toLowerCase();
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
        str = funcmanager(str);
        AbstractTreeBuilder tree = new AbstractTreeBuilder(str);
        value = tree.getTree().getNumericResult(value);
        return value;

    }


    public void disableButtonClick(EditText txt) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            txt.setRawInputType(InputType.TYPE_NULL);
            txt.setShowSoftInputOnFocus(false);
        } else {
            txt.setRawInputType(InputType.TYPE_NULL);
            txt.setTextIsSelectable(true);
        }
    }


}


