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
    TableLayout table;


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