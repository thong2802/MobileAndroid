package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    Button btn_stop;
    EditText data_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });
    }

    private void clickStartService() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key data intent", data_intent.getText().toString().trim());
        startService(intent);
    }
    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
    private void Anhxa() {
        btn_start = findViewById(R.id.btn_startService);
        btn_stop = findViewById(R.id.btn_stopService);
        data_intent = findViewById(R.id.data_intent);
    }
}