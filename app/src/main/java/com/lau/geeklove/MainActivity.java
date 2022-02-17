package com.lau.geeklove;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] languages = {"Java", "Python", "Swift", "Ruby", "C#", "Kotlin"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItem;
    ImageView imageView;
    EditText nameInput;
    Button button;
    String itemName;
//    TextView r1col0;
//    TextView r1col1;
//    TextView r1col2;
//    TextView r2col0;
//    TextView r2col1;
//    TextView r2col2;
//    TextView r3col0;
//    TextView r3col1;
//    TextView r3col2;
//    TextView r4col0;
//    TextView r4col1;
//    TextView r4col2;
//    TextView r5col0;
//    TextView r5col1;
//    TextView r5col2;
//    TextView r6col0;
//    TextView r6col1;
//    TextView r6col2;
    boolean[] isFilled;

    TableLayout table;
    ArrayList<String[]> forTable;

//    public void clearTable() {
//        r1col0 = findViewById(R.id.r1col0);
//        r1col1 = findViewById(R.id.r1col1);
//        r1col2 = findViewById(R.id.r1col2);
//        r2col0 = findViewById(R.id.r2col0);
//        r2col1 = findViewById(R.id.r2col1);
//        r2col2 = findViewById(R.id.r2col2);
//        r3col0 = findViewById(R.id.r3col0);
//        r3col1 = findViewById(R.id.r3col1);
//        r3col2 = findViewById(R.id.r3col2);
//        r4col0 = findViewById(R.id.r4col0);
//        r4col1 = findViewById(R.id.r4col1);
//        r4col2 = findViewById(R.id.r4col2);
//        r5col0 = findViewById(R.id.r5col0);
//        r5col1 = findViewById(R.id.r5col1);
//        r5col2 = findViewById(R.id.r5col2);
//        r6col0 = findViewById(R.id.r6col0);
//        r6col1 = findViewById(R.id.r6col1);
//        r6col2 = findViewById(R.id.r6col2);
//        r1col0.setText("");
//        r1col1.setText("");
//        r1col2.setText("");
//        r2col0.setText("");
//        r2col1.setText("");
//        r2col2.setText("");
//        r3col0.setText("");
//        r3col1.setText("");
//        r3col2.setText("");
//        r4col0.setText("");
//        r4col1.setText("");
//        r4col2.setText("");
//        r5col0.setText("");
//        r5col1.setText("");
//        r5col2.setText("");
//        r6col0.setText("");
//        r6col1.setText("");
//        r6col2.setText("");
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItem = new ArrayAdapter<String>(this, R.layout.list_item, languages);
        autoCompleteTxt.setAdapter(adapterItem);
        imageView = findViewById(R.id.imageView);
        nameInput = (EditText) findViewById(R.id.nameInput);
        button = findViewById(R.id.button);
        table = (TableLayout) findViewById(R.id.table);
        forTable = new ArrayList<String[]>();
//        r1col0 = findViewById(R.id.r1col0);
//        r1col1 = findViewById(R.id.r1col1);
//        r1col2 = findViewById(R.id.r1col2);
//        r2col0 = findViewById(R.id.r2col0);
//        r2col1 = findViewById(R.id.r2col1);
//        r2col2 = findViewById(R.id.r2col2);
//        r3col0 = findViewById(R.id.r3col0);
//        r3col1 = findViewById(R.id.r3col1);
//        r3col2 = findViewById(R.id.r3col2);
//        r4col0 = findViewById(R.id.r4col0);
//        r4col1 = findViewById(R.id.r4col1);
//        r4col2 = findViewById(R.id.r4col2);
//        r5col0 = findViewById(R.id.r5col0);
//        r5col1 = findViewById(R.id.r5col1);
//        r5col2 = findViewById(R.id.r5col2);
//        r6col0 = findViewById(R.id.r6col0);
//        r6col1 = findViewById(R.id.r6col1);
//        r6col2 = findViewById(R.id.r6col2);
        isFilled = new boolean[6];
        for (int i = 0; i < isFilled.length; i++) {
            isFilled[i] = false;
        }


        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getItemAtPosition(i).toString();
                switch (item) {
                    case "Java":
                        imageView.setImageResource(R.drawable.java);
                        imageView.animate().rotationBy(360).setDuration(2000).start();
                        break;
                    case "Python":
                        imageView.setImageResource(R.drawable.python);
                        imageView.animate().rotationBy(360).setDuration(2000).start();
                        break;
                    case "Swift":
                        imageView.setImageResource(R.drawable.swift);
                        imageView.animate().rotationBy(360).setDuration(2000).start();
                        break;
                    case "C#":
                        imageView.setImageResource(R.drawable.csharp);
                        imageView.animate().rotationBy(360).setDuration(2000).start();
                        break;
                    case "Ruby":
                        imageView.setImageResource(R.drawable.ruby);
                        imageView.animate().rotationBy(360).setDuration(2000).start();
                        break;
                    case "Kotlin":
                        imageView.setImageResource(R.drawable.kotlin);
                        imageView.animate().rotationBy(360).setDuration(2000).start();
                        break;
                }
                itemName = item;
            }
        });

    }

    public void calculator(View v) {
        if (itemName == null) {
            Toast.makeText(getApplicationContext(), "Select a language!", Toast.LENGTH_LONG).show();
        } else {
            String name = nameInput.getText().toString();
            if (name.equals("")) {
                Toast.makeText(getApplicationContext(), "Enter a Name!", Toast.LENGTH_LONG).show();
            } else {
                Random rand = new Random();
                int random = rand.nextInt(101);
//                if (isFilled[isFilled.length - 1]) {
//                    Toast.makeText(getApplicationContext(), "The table will be cleared", Toast.LENGTH_LONG).show();
////                    clearTable();
//                }
//                if (!isFilled[0]) {
//                    r1col0.setText(name);
//                    r1col1.setText(itemName);
//                    r1col2.setText(random);
//                }
                TableRow row = new TableRow(this);
                row.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT));
                TextView col0 = new TextView(this);
                col0.setText(name);
                col0.setGravity(Gravity.CENTER_HORIZONTAL);
                col0.setPadding(160 , 10 ,200 , 10);
                col0.setTextColor(Color.BLACK);
                col0.setTextSize(14);
                row.addView(col0);
                TextView col1 = new TextView(this);
                col1.setText(itemName);
                col1.setGravity(Gravity.CENTER_HORIZONTAL);
                col1.setPadding(170 , 10 ,150 , 10);
                col1.setTextColor(Color.BLACK);
                col1.setTextSize(14);
                row.addView(col1);
                TextView col2 = new TextView(this);
                col2.setText(String.valueOf(random));
                col2.setGravity(Gravity.CENTER_HORIZONTAL);
                col2.setPadding(160 , 10 ,180 , 10);
                col2.setTextColor(Color.BLACK);
                col2.setTextSize(14);
                row.addView(col2);
                table.addView(row);
            }
        }
    }
}