package com.example.mycontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycontact.adapters.MyAdapter;
import com.example.mycontact.models.Contact;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListContactActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> listContact;
    MyAdapter myAdapter;

    TextView uidContact;

    FloatingActionButton fabAdd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        Bundle bundle = getIntent().getExtras();
        String uid = bundle.getString("uid");

        fabAdd = findViewById(R.id.fab_add);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListContactActivity.this, AjouterContactActivity.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtra("uid",bundle.getString("uid"));
                startActivity(intent);
            }
        });


        recyclerView = findViewById(R.id.recyclerVii);
        //TODO search functions
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ListContactActivity.this,1);

        recyclerView.setLayoutManager(gridLayoutManager);
        listContact = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users").document(uid).collection("Contacts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful() && !task.getResult().isEmpty()) {
                            for (QueryDocumentSnapshot doc: task.getResult()) {

                                listContact.add(new Contact(
                                        doc.getString("nomContact"),
                                        doc.getString("prenomContact"),
                                        doc.getString("serviceContact"),
                                        doc.getString("emailContact"),
                                        doc.getString("telContact"),
                                        "sdfsdf",
                                        false,
                                        doc.getId()));
                                myAdapter = new MyAdapter(ListContactActivity.this,listContact, uid);

                                recyclerView.setAdapter(myAdapter);





                            }

                        }
                        else {

                            Toast.makeText(ListContactActivity.this,"Theres a problem",Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }
}