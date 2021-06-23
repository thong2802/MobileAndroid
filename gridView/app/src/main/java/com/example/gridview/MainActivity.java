package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    GridView gridView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Anhxa();
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        arrayList.add("VN");
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
    public void Anhxa(){
        gridView = findViewById(R.id.gridview);
    }
}