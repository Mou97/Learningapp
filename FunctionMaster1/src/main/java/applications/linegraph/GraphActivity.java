package applications.linegraph;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;


import ast.Operation;
import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;


import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    LineChart lineChart;
    ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
    int numDataPoints;
    String save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        lineChart = (LineChart) findViewById(R.id.lineChart);

        Intent intent = getIntent();
        Double a = intent.getDoubleExtra("number1", 0);
        Double b = intent.getDoubleExtra("number2", 0);
        String str = intent.getStringExtra("text");
        str = str.toLowerCase();
        save = str;

        ArrayList<String> xAXES = new ArrayList<>();

        draw(str, a, b);

        double x = a;
        for (int i = 0; i < numDataPoints; i++) {
            x += 0.001;
            xAXES.add(i, String.valueOf(x));
        }


        String[] xaxes = new String[xAXES.size()];
        for (int i = 0; i < xAXES.size(); i++) {
            xaxes[i] = xAXES.get(i).toString();
        }

        lineChart.setData(new LineData(xaxes, lineDataSets));
        lineChart.getXAxis().setEnabled(true);
        lineChart.getXAxis().setAxisLineColor(Color.RED);
        lineChart.setBorderColor(Color.RED);

        lineChart.setVisibleXRangeMaximum((float) ((a - b) / (0.001)) + 3);


    }


    public static Double func(String str, Double value) throws TokenizerException {
        AbstractTreeBuilder tree = new AbstractTreeBuilder(str);
        value = tree.getTree().getNumericResult(value);
        return value;

    }


    public void openActivity1() {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }


    public static String funcmanager(String val) {
        char c;
        val.replace("pi", "" + Math.PI);
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

    public void draw(String str, Double start, Double end) {
        str = funcmanager(str);

        numDataPoints = (int) (Math.abs(start - end) / 0.001);
        ArrayList<Entry> yAXES = new ArrayList<>();
        double x = start;

        for (int i = 0; i < numDataPoints; i++) {
            float sinFunction = 0;
            try {
                if (Math.abs(func(str, x)) < 10000000) {
                    sinFunction = Float.parseFloat(String.valueOf(func(str, x)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            x = x + 0.001;
            yAXES.add(new Entry(sinFunction, i));
        }

        LineDataSet lineDataSet1 = new LineDataSet(yAXES, "f(x) = " + save);
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.RED);
        lineDataSets.add(lineDataSet1);

    }

}
