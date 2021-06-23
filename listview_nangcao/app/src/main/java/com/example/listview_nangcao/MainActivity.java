package com.example.listview_nangcao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    ListView listView;
    ArrayList<DataModel_quocgia> arrayList_quocgia = new ArrayList<>();
    Adapter_Quocgia adapter_quocgia = new Adapter_Quocgia(this, R.layout.quocgia, arrayList_quocgia);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Anhxa();
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList_quocgia.add(new DataModel_quocgia("Việt Nam", "Hà Nội", R.drawable.vn));
        listView.setAdapter(adapter_quocgia);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Bạn có đồng ý xoá không");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayList_quocgia.remove(position);
                        adapter_quocgia.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                dialog.show();
                return false;
            }
        });
    }
    public void Anhxa(){
        listView = (ListView)findViewById(R.id.list_item);
    }
}