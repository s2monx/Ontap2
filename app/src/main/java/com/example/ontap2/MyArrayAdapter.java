package com.example.ontap2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;

    public MyArrayAdapter(@NonNull Activity context, int resource, ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.myArray = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if(myArray.size() > 0 && position >= 0){
            final TextView tvitem = convertView.findViewById(R.id.tvitem);
            final NhanVien nv = myArray.get(position);
            tvitem.setText(nv.toString());
            final ImageView imgitem = convertView.findViewById(R.id.imgitem);
            if (nv.isGender()){
                imgitem.setImageResource(R.drawable.girlicon);
            }
            else{
                imgitem.setImageResource(R.drawable.boyicon);
            }
        }
        return convertView;
    }
}
