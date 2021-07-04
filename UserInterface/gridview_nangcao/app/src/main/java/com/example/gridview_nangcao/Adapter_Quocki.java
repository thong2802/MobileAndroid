package com.example.gridview_nangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_Quocki  extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<DataModel_Quocgia> arrayList;

    public Adapter_Quocki(Context context, int layout, ArrayList<DataModel_Quocgia> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        TextView nameCountry;
        ImageView imageView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            // anh xa
            viewHolder.nameCountry = (TextView) convertView.findViewById(R.id.name);
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // gan gia tri
           viewHolder.nameCountry.setText(arrayList.get(position).getNameCountry());
           viewHolder.imageView.setImageResource(arrayList.get(position).getImageQuocki());


        return convertView;
    }
}
