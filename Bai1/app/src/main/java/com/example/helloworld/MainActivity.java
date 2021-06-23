package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class MainActivity extends AppCompatActivity {
   Button btn;
   TextView text;
   public static final int REQUEST_CODE = 123;
   public static final String TAG = MainActivity.class.getSimpleName();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivityForResult(intent, REQUEST_CODE );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            String name = data.getStringExtra("newnamemoi");
            text.setText(name);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void AnhXa(){
         btn = findViewById(R.id.btn1);
         text = findViewById(R.id.text1);
    }
}