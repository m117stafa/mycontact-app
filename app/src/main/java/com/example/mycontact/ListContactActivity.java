package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycontact.adapters.MyAdapter;
import com.example.mycontact.models.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListContactActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> listContact;
    MyAdapter myAdapter;

    FloatingActionButton fabAdd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        fabAdd = findViewById(R.id.fab_add);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListContactActivity.this, AjouterContactActivity.class);
                startActivity(intent);
            }
        });


        recyclerView = findViewById(R.id.recyclerVii);
        //TODO search functions
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ListContactActivity.this,1);

        recyclerView.setLayoutManager(gridLayoutManager);
        listContact = new ArrayList<>();
        listContact.add(new Contact("df","Df","df","Df","df","https://i.pravatar.cc/300",true));
        listContact.add(new Contact("tyf","Dyyf","dyyf","Dfyy","dfyy","Dfyy",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",false));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));
        listContact.add(new Contact("df","Df","df","Df","df","Df",true));


        myAdapter = new MyAdapter(this,listContact);
        recyclerView.setAdapter(myAdapter);
    }
}