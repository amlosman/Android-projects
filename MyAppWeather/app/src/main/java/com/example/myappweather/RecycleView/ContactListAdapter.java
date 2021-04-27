package com.example.myappweather.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappweather.R;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.CustomViewHolder> {

    public ArrayList<weatherInfo> contacts;
    private OnCityListener onCityListener;
    private LayoutInflater mInflater;

    public ContactListAdapter(ArrayList<weatherInfo> contacts, Context context , OnCityListener onCityListener) {
        this.contacts = contacts;
        this.mInflater = LayoutInflater.from(context);
        this.onCityListener = onCityListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.items, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        weatherInfo weatherInf = contacts.get(position);
        holder.City.setText(weatherInf.city);



    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView City;

        CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            City = itemView.findViewById(R.id.item);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onCityListener.OnCityClick(getAdapterPosition());
               }
           });

        }



    }
    public  interface OnCityListener{
        void OnCityClick(int position);
    }
}
