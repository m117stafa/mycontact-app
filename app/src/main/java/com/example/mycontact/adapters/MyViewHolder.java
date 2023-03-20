package com.example.mycontact.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontact.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView recImage;
    TextView  phoneCard, fullnameCard, rec;
    CardView recCard;

    TextView uidContact;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        phoneCard = itemView.findViewById(R.id.phoneCard);
        fullnameCard = itemView.findViewById(R.id.fullnameCard);
        recCard = itemView.findViewById(R.id.recCard);
        uidContact = itemView.findViewById(R.id.uid_contact);
    }
}
