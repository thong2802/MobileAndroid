package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
  Button btn2;
  EditText text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Anhxa();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname = text2.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("newnamemoi", newname);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }

    public void Anhxa(){
        btn2 = (Button)findViewById(R.id.btn2);
        text2 = (EditText) findViewById(R.id.text2);
    }
}