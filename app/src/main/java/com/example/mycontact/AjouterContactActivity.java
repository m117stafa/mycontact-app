package com.example.mycontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mycontact.models.Contact;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AjouterContactActivity extends AppCompatActivity {

    Button btnAjouter;

    TextInputEditText editTextNomAj, editTextPrenomAj, editTextEmailAj, editTextNumAj
            ,editTextServiceAj;

    ProgressBar progressBarLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_contact);

        editTextNomAj = findViewById(R.id.nom_added_contact);
        editTextPrenomAj = findViewById(R.id.prenom_added_contact);
        editTextEmailAj = findViewById(R.id.email_added_contact);
        editTextNumAj = findViewById(R.id.numtele_added_contact);
        editTextServiceAj = findViewById(R.id.service_added_contact);
        btnAjouter = findViewById(R.id.btn_ajouter);

        progressBarLoading = findViewById(R.id.progress_cercle_ajoute);

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getExtras();
                String uid = bundle.getString("uid");

                String emailContact, nomContact,
                        prenomContact, numContact, serviceContact;
                emailContact = String.valueOf(editTextEmailAj.getText());
                nomContact = String.valueOf(editTextNomAj.getText());
                prenomContact = String.valueOf(editTextPrenomAj.getText());
                numContact = String.valueOf(editTextNumAj.getText());
                serviceContact = String.valueOf(editTextServiceAj.getText());
                String imgUrl = "https://i.pravatar.cc/300";

                Contact addedContact = new Contact(nomContact,prenomContact,
                        serviceContact,emailContact,numContact,imgUrl,true );


                progressBarLoading.setVisibility(View.VISIBLE);
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                db.collection("users").document(uid).collection("Contacts")
                        .add(addedContact)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    progressBarLoading.setVisibility(View.INVISIBLE);
                                    Toast.makeText(AjouterContactActivity.this,"Contact is added",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    progressBarLoading.setVisibility(View.INVISIBLE);
                                    Toast.makeText(AjouterContactActivity.this,"Theres a problem",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }
}