package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CheckActivity extends AppCompatActivity {
    TextView affichernum1;
    TextView affichernum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Intent intent = new Intent();
        int num1 = intent.getIntExtra("challenge1",0);
        int num2 = intent.getIntExtra("challenge2",0);
        affichernum1=findViewById(R.id.textView8);
        affichernum2=findViewById(R.id.textView12);

        affichernum1.setText(Integer.toString(num1));
        affichernum2.setText(Integer.toString(num2));

        //EditText result = (EditText) findViewById(R.id.editTextTextPersonName);

    }




}