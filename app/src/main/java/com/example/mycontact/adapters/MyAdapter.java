package com.example.mycontact.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontact.DetailContactActivity;
import com.example.mycontact.R;
import com.example.mycontact.models.Contact;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<Contact> listContact;

    public MyAdapter(Context context, List<Contact> listContact) {
        this.context = context;
        this.listContact = listContact;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.fullnameCard.setText(TextUtils.concat(listContact.get(position).getNomContact()," ",
                listContact.get(position).getPrenomContact()));

        holder.phoneCard.setText(listContact.get(position).getTelContact());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailContactActivity.class);

                //TODO continue using intent.putExtra to show
                //data in next page

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }

}
