package com.lau.geeklove;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] languages = {"Java", "Python", "Swift", "Ruby", "C#", "Kotlin"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItem;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItem = new ArrayAdapter<String>(this, R.layout.list_item, languages);
        autoCompleteTxt.setAdapter(adapterItem);
        imageView = findViewById(R.id.imageView);

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
                imageView.setVisibility(ImageView.VISIBLE);
                Toast.makeText(getApplicationContext(), "Item: " + item, Toast.LENGTH_LONG).show();
            }
        });

    }
}