package com.example.tp2;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {
    TextView txt1;
    TextView txt2;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        final Intent intent = getIntent();
        int challenge1 = intent.getIntExtra("challenge1",0);
        int challenge2 = intent.getIntExtra("challenge2",1);
        txt1 = (TextView)findViewById( R.id.textView8 );
        txt2 = (TextView)findViewById( R.id.textView12 );
        txt1.setText(Integer.toString(challenge1));
        txt2.setText(Integer.toString(challenge2));

        result = (EditText)findViewById( R.id.editTextTextPersonName );
    }

    public void cancel(View view) {
        finish();
        Toast.makeText(this, "l’opération a été annulée", Toast.LENGTH_SHORT).show();}

    public void ok(View view){
        int somme = Integer.parseInt(result.getText().toString());
        Intent resultIntent = new Intent();
        resultIntent.putExtra("somme",somme);
        setResult(Activity.RESULT_OK,resultIntent);
        finish();
    }


}