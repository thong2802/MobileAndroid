package com.example.clicknotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailActivity2 extends AppCompatActivity {
    Button button_gotoActivityMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Anhxa();

        //button_gotoActivityMain
        button_gotoActivityMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        button_gotoActivityMain = findViewById(R.id.go_to_main);
    }
}