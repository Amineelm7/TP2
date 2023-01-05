package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    int Perm_CTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void contact(View view) {
        Intent myIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts/people"));
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS}, Perm_CTC);
        startActivityForResult(myIntent,2);
 }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==  2) {
            if (resultCode == Activity.RESULT_CANCELED) {
                TextView textView5 = findViewById(R.id.textView5);
            }

        }
    }
}