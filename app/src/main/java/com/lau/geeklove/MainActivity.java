package com.lau.geeklove;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
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
    TextView txtView;
    TableLayout table;
    ArrayList<String[]> forTable;


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
                String[] toAdd= {name , itemName , String.valueOf(random)};
                forTable.add(0 , toAdd);
                TextView col0 = new TextView(this);
                col0.setText(forTable.get(0)[0]);
                col0.setTextColor(Color.BLACK);
                ViewGroup.LayoutParams paramsCol0 = col0.getLayoutParams();
                col0.setPadding(14 ,14 , 14 ,14);
                TextView col1 = new TextView(this);
                col1.setText(forTable.get(0)[1]);
                TextView col2 = new TextView(this);
                col2.setText(forTable.get(0)[2]);
                TableRow row = new TableRow(this);
                ViewGroup.LayoutParams params = row.getLayoutParams();
                row.addView(col0);
                row.addView(col1);
                row.addView(col2);
                table.addView(row);


            }
        }
    }
}