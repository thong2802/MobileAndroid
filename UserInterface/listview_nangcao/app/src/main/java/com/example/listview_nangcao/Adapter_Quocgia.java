package com.example.listview_nangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_Quocgia extends BaseAdapter {
    Context context;
    int layout;
    List<DataModel_quocgia> dataModel_quocgias;

    public Adapter_Quocgia(Context context, int layout, List<DataModel_quocgia> dataModel_quocgias) {
        this.context = context;
        this.layout = layout;
        this.dataModel_quocgias = dataModel_quocgias;
    }

    @Override
    public int getCount() {
        return dataModel_quocgias.size();
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
        TextView tvnuoc, tvthudo;
        ImageView quocki;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        DataModel_quocgia dataModel_quocgia = (DataModel_quocgia) getItem(position);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            //anh xa
            viewHolder = new ViewHolder();
            viewHolder.tvnuoc = (TextView)convertView.findViewById(R.id.tenquocgia);
            viewHolder.tvthudo = (TextView)convertView.findViewById(R.id.thudo);
            viewHolder.quocki = (ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // gan gia tri
        viewHolder.tvnuoc.setText(dataModel_quocgias.get(position).getTenNuoc());
        viewHolder.tvthudo.setText(dataModel_quocgias.get(position).getThuDo());
        viewHolder.quocki.setImageResource(dataModel_quocgias.get(position).getHinhAnh());

        return convertView;
    }
}
