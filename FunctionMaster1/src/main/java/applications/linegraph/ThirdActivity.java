package applications.linegraph;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ast.Operation;
import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;

public class ThirdActivity extends AppCompatActivity {
    private boolean invalide;
    private String str;
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        edittext = (EditText) findViewById(R.id.editText);
        //custom font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu/Ubuntu-Regular.ttf");
        edittext.setTypeface(typeface);
        /* -----------------------------------------------------------------*/


        Button button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invalide = false;
                str = edittext.getText().toString();
                //str = funcmanager(str);
                try {
                    String z = dfunc(str);

                } catch (Exception  e) {             //non-valid expression ,, error message
                    Drawable warning = (Drawable) getResources().getDrawable(R.drawable.icon_warning);
                    warning.setBounds(0, 0, warning.getIntrinsicWidth(), warning.getIntrinsicHeight());
                    edittext.setError("Format non-valide", warning);
                    invalide = true;

                }
                if (edittext.getText().toString().equals("")) {
                    Toast.makeText(ThirdActivity.this, "Veuiller entrer une fonction", Toast.LENGTH_SHORT).show();
                } else if (!invalide) {
                    //String text = edittext.getText().toString();
                    Intent intent = new Intent(ThirdActivity.this, DerivActivity.class);
                    //intent.putExtra("textos", text);
                    intent.putExtra("textos", str);
                    startActivityForResult(intent, 1);

                }
            }
        });
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
