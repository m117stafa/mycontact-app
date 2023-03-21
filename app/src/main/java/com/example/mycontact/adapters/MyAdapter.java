package com.example.mycontact.adapters;



import android.content.Context;
import android.content.Intent;

import android.text.TextUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontact.DetailContactActivity;
import com.example.mycontact.R;
import com.example.mycontact.models.Contact;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<Contact> listContact;

    private String uid;

    public MyAdapter(Context context, List<Contact> listContact, String uid) {
        this.context = context;
        this.listContact = listContact;
        this.uid = uid;
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

        holder.uidContact.setText(listContact.get(position).getUidContact());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailContactActivity.class);




                intent.putExtra("nom",listContact.get(holder.getAdapterPosition()).getNomContact());
                intent.putExtra("prenom",listContact.get(holder.getAdapterPosition()).getPrenomContact());
                intent.putExtra("phone",listContact.get(holder.getAdapterPosition()).getTelContact());
                intent.putExtra("email",listContact.get(holder.getAdapterPosition()).getEmailContact());
                intent.putExtra("service",listContact.get(holder.getAdapterPosition()).getServiceContact());
                intent.putExtra("image",listContact.get(holder.getAdapterPosition()).getImgUrl());
                intent.putExtra("uidContact",listContact.get(holder.getAdapterPosition()).getUidContact());



                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }

}
