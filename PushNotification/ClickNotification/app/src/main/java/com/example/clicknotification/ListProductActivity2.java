package com.example.clicknotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListProductActivity2 extends AppCompatActivity {
   Button button_gotodetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product2);
        Anhxa();

        //button_gotodetail
        button_gotodetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListProductActivity2.this, DetailActivity2.class);
                startActivity(intent);
            }
        });

    }
   // anhxa
    private void Anhxa() {
        button_gotodetail = findViewById(R.id.go_to_detail);
    }
}