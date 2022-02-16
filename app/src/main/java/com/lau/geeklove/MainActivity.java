package com.lau.geeklove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] languages= {"Java" , "Python" , "Swift" , "Ruby" , "C#" , "Kotlin"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter <String> adapterItem ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItem = new ArrayAdapter<String>(this,R.layout.list_item,languages);
        autoCompleteTxt.setAdapter(adapterItem);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),"Item: " + item , Toast.LENGTH_LONG).show();
            }
        });

    }
}