package com.example.gridview_nangcao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
   GridView gridView;
   Adapter_Quocki adapter_quocki;
   ArrayList<DataModel_Quocgia> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Anhxa();
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));
        arrayList.add(new DataModel_Quocgia("VietNam", R.drawable.vietnam));

        adapter_quocki = new Adapter_Quocki(this, R.layout.quocki, arrayList);
        gridView.setAdapter(adapter_quocki);


        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xac nhan");
                dialog.setMessage("Xoa hay khong");
                dialog.setPositiveButton("XOA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayList.remove(position);
                        adapter_quocki.notifyDataSetChanged();
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

    private void Anhxa() {
        gridView = findViewById(R.id.gridview);
    }
}