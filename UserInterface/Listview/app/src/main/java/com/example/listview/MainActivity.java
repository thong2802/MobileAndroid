package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  EditText text1;
  Button button2;
  Button button3;
  private int vitri = -1;
  private   ListView listView;
  private   Context context;
  private String[] listData;
  private ArrayList<String> lisData1 = new ArrayList<>();
  private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Anhxa();
        //listData = context.getResources().getStringArray(R.array.listVideo);
//        listData = new String[] {
//                "Bai1",
//                "Bai2",
//                "Bai3",
//                "Bai4",
//                "Bai5",
//                "Bai6",
//                "Bai7",
//                "Bai8",
//                "Bai9",
//                "Bai10"
//        };
        lisData1.add("Bai1");
        lisData1.add("Bai2");
        lisData1.add("Bai3");
        lisData1.add("Bai4");
        lisData1.add("Bai5");
        lisData1.add("Bai6");

        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, lisData1);
        listView.setAdapter(arrayAdapter);

        //
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = text1.getText().toString().trim();
                if (TextUtils.isDigitsOnly(newItem)) {
                    Toast.makeText(MainActivity.this, "Vui long khong bor trong", Toast.LENGTH_SHORT).show();
                }else {
                    lisData1.add(newItem);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,lisData1.get(position), Toast.LENGTH_SHORT).show();
                text1.setText(lisData1.get(position));
                vitri = position;

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text1 == null){
                    Toast.makeText(MainActivity.this, "Vui long khong bor trong", Toast.LENGTH_SHORT).show();
                }else {
                    lisData1.set(vitri, text1.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });

        //
       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               AlertDialog.Builder dialog = new AlertDialog.Builder(context);
               dialog.setTitle("Xac nhan");
               dialog.setMessage("Ban co dong y xoa khong");
               dialog.setPositiveButton("Xoa", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       lisData1.remove(position);
                       arrayAdapter.notifyDataSetChanged();
                   }
               });
               dialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });

               AlertDialog alertDialog = dialog.create();
               alertDialog.show();
               return false;
           }
       });


    }

    //

    ///

    public void Anhxa(){
        listView = (ListView)findViewById(R.id.list_item);
        text1 = (EditText)findViewById(R.id.edittext1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
    }
}