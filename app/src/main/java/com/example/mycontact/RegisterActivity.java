package com.example.mycontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycontact.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText editTextNom, editTextPrenom, editTextEmail, editTextNum
            ,editTextMotpass;
    Button buttonInscrit;
    TextView textConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextNom = findViewById(R.id.nom_user);
        editTextPrenom = findViewById(R.id.prenom_user);
        editTextEmail = findViewById(R.id.email_user);
        editTextNum = findViewById(R.id.numtele_user);
        editTextMotpass = findViewById(R.id.motpass_user);
        buttonInscrit = findViewById(R.id.btn_inscrit);
        textConnection = findViewById(R.id.text_connecter);



        buttonInscrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser, motpassUser, nomUser, prenomUser, numUser;
                emailUser = String.valueOf(editTextEmail.getText());
                motpassUser = String.valueOf(editTextMotpass.getText());
                nomUser = String.valueOf(editTextNom.getText());
                prenomUser = String.valueOf(editTextPrenom.getText());
                numUser = String.valueOf(editTextNum.getText());

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                if (TextUtils.isEmpty(emailUser) || TextUtils.isEmpty(motpassUser) || TextUtils.isEmpty(nomUser) || TextUtils.isEmpty(prenomUser) || TextUtils.isEmpty(numUser)){
                    Toast.makeText(RegisterActivity.this,"Remplir tous les cases",Toast.LENGTH_SHORT).show();
                    return;
                }

                Query checkEmail = db.collection("users").whereEqualTo("emailUser",emailUser);



                db.collection("users")
                        .add(new User(emailUser,numUser,motpassUser,nomUser,prenomUser))
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("TAG","DocumentSnapshot added with ID: "+ documentReference.getId());
                                Toast.makeText(RegisterActivity.this,"Vous etes inscrit maintenant", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error adding document", e);
                                Toast.makeText(RegisterActivity.this,"Il y a un problem", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

        textConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }


    }


}