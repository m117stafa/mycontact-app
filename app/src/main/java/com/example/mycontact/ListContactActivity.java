package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mycontact.adapters.MyAdapter;
import com.example.mycontact.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ListContactActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> listContact;
    MyAdapter myAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        recyclerView = findViewById(R.id.recyclerVii);
        //TODO search functions
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ListContactActivity.this,1);

        recyclerView.setLayoutManager(gridLayoutManager);
        listContact = new ArrayList<>();
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("tyf","Dyyf","dyyf","Dfyy","dfyy","Dfyy"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));
        listContact.add(new Contact("df","Df","df","Df","df","Df"));


        myAdapter = new MyAdapter(this,listContact);
        recyclerView.setAdapter(myAdapter);
    }
}