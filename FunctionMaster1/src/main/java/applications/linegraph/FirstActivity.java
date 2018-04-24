package applications.linegraph;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ast.Operation;
import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;


public class FirstActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private boolean invalide;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        editText1 = (EditText) findViewById(R.id.edittext1);
        editText2 = (EditText) findViewById(R.id.edittext2);
        editText3 = (EditText) findViewById(R.id.edittext3);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                invalide = false;
                str = editText3.getText().toString();
                str = str.toLowerCase();
                str = funcmanager(str);
                try {
                    String z = dfunc(str);

                } catch (Exception e) {             //non-valid expression ,, error message
                    Drawable warning = (Drawable) getResources().getDrawable(R.drawable.icon_warning);
                    warning.setBounds(2, 2, warning.getIntrinsicWidth(), warning.getIntrinsicHeight());
                    editText3.setError("Format non-valide", warning);
                    invalide = true;

                }
                if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                    Toast.makeText(FirstActivity.this, "Veuillez inserer un numéro", Toast.LENGTH_SHORT).show();
                } else if (editText3.getText().toString().equals("")) {
                    Toast.makeText(FirstActivity.this, "Veuillez inserer une fonction", Toast.LENGTH_SHORT).show();
                } else if (!invalide) {
                    openActivity2();
                }
            }
        });


    }


    public void openActivity2() {


        Double number1 = Double.parseDouble(editText1.getText().toString());
        Double number2 = Double.parseDouble(editText2.getText().toString());

        Intent intent = new Intent(FirstActivity.this, GraphActivity.class);
        intent.putExtra("number1", number1);
        intent.putExtra("number2", number2);
        intent.putExtra("text", str);

        startActivityForResult(intent, 1);
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

    public static String dfunc(String str) throws TokenizerException {
        AbstractTreeBuilder tree = new AbstractTreeBuilder(str);
        Operation derivative = tree.getTree().getDerivative();
        return derivative.toString();
    }
}


