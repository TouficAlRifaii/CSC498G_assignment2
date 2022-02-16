package com.lau.geeklove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        txtView = findViewById(R.id.textView);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getItemAtPosition(i).toString();
                switch (item) {
                    case "Java":
                        imageView.setImageResource(R.drawable.java);
                        break;
                    case "Python":
                        imageView.setImageResource(R.drawable.python);
                        break;
                    case "Swift":
                        imageView.setImageResource(R.drawable.swift);
                        break;
                    case "C#":
                        imageView.setImageResource(R.drawable.csharp);
                        break;
                    case "Ruby":
                        imageView.setImageResource(R.drawable.ruby);
                        break;
                    case "Kotlin":
                        imageView.setImageResource(R.drawable.kotlin);
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
                txtView.setText("The relationship between " + name + " and " + itemName + " is based on " + random + "% true love!");
                imageView.setVisibility(ImageView.VISIBLE);
            }
        }
    }
}