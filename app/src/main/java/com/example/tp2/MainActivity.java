package com.example.tp2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tp2.R;

public class MainActivity extends AppCompatActivity {
    private static boolean result=false;
    private int CALL_Perm;
    EditText challenge1;
    EditText challenge2;

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.i("LIFECYCLE ", getLocalClassName() + " : ici onActivityResult: ");

                    if (result.getResultCode()== 78){
                        Intent intent = result.getData();

                        if (intent!=null){
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]
                                    {Manifest.permission.CALL_PHONE}, CALL_Perm);
                            EditText txt = findViewById(R.id.editTxtPhone);
                            String number = txt.getText().toString();
                            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number)));
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        challenge1 = findViewById(R.id.entier1);
        challenge2 = findViewById(R.id.entier2);
    }

    public void callNumber(View view){
        Intent myIntent = new Intent(MainActivity.this,LoginActivity.class);
        activityLauncher.launch(myIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CALL_Perm) {
            //the array is empty if not granted
            if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "GRANTED CALL",Toast.LENGTH_SHORT).show();
        }
    }

    public void searchUrl(View view){

        if (!challenge1.getText().toString().equals("") && !challenge2.getText().toString().equals("")) {
            Intent IntentCheck = new Intent(MainActivity.this,CheckActivity.class);
            IntentCheck.putExtra("challenge1",Integer.parseInt(challenge1.getText().toString()));
            IntentCheck.putExtra("challenge2",Integer.parseInt(challenge2.getText().toString()));
            startActivityForResult(IntentCheck,1);
        }

        /*EditText url = findViewById(R.id.edtTxtUrl);
        String urlName = url.getText().toString();
        if (!urlName.startsWith("http://") && !urlName.startsWith("https://")){
            urlName = "http://" + urlName;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlName));
        startActivity(browserIntent);*/
    }

    public void persoActivity(View view){
        Intent myIntent = new Intent(this,PersoActivity.class);
        startActivity(myIntent);
    }


}
