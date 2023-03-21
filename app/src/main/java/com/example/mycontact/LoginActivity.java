package com.example.mycontact;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText editTextEmailLogin, editTextMotpassLogin;
    Button loginButton;
    TextView textInscription;
    ProgressBar progressBarLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmailLogin = findViewById(R.id.email);
        editTextMotpassLogin = findViewById(R.id.motpass);
        loginButton = findViewById(R.id.btn_se_connecter);
        textInscription = findViewById(R.id.text_inscri);
        progressBarLoading = findViewById(R.id.progress_cercle);


        textInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailLogin, motpassLogin;
                emailLogin = String.valueOf(editTextEmailLogin.getText());
                motpassLogin = String.valueOf(editTextMotpassLogin.getText());

                if (TextUtils.isEmpty(emailLogin) || TextUtils.isEmpty(motpassLogin)) {
                    Toast.makeText(LoginActivity.this, "Remplir tous les cases", Toast.LENGTH_SHORT).show();
                    return;
                }

                final FirebaseFirestore db = FirebaseFirestore.getInstance();
                progressBarLoading.setVisibility(View.VISIBLE);
                Log.d(TAG, "onClick: ----- 9bal db collection");
                Log.d(TAG, "onClick: -------" + emailLogin + "  " + motpassLogin);
                db.collection("users").whereEqualTo("emailUser", emailLogin)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()) {

                                    if (task.getResult().isEmpty()) {
                                        Log.d(TAG, "onComplete: info ghaltin hhh ");
                                        Toast.makeText(LoginActivity.this, "les informations sont incorrect", Toast.LENGTH_SHORT).show();
                                        editTextEmailLogin.requestFocus();
                                        return;
                                    }
                                    DocumentSnapshot doc = task.getResult().getDocuments().get(0);
                                    String emailFromDb = (String) doc.get("emailUser");
                                    String motpassFromDb = (String) doc.get("motPass");
                                    Log.d(TAG, "onComplete: " + emailFromDb + " " + motpassFromDb);
                                    if (emailFromDb.equals(emailLogin) && motpassFromDb.equals(motpassLogin)) {
                                        Log.d(TAG, "onComplete: sgsdgggggggggggggggggggg");
                                        progressBarLoading.setVisibility(View.INVISIBLE);
                                        Toast.makeText(LoginActivity.this, "Vous etes connecte", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(LoginActivity.this, ListContactActivity.class);
                                        intent.putExtra("nom", (String) doc.get("nomUser"));
                                        intent.putExtra("prenom", (String) doc.get("prenomUser"));
                                        intent.putExtra("num", (String) doc.get("numUser"));
                                        intent.putExtra("email", (String) doc.get("emailUser"));
                                        intent.putExtra("uid", doc.getId());
                                        startActivity(intent);
                                    } else {
                                        progressBarLoading.setVisibility(View.INVISIBLE);
                                        Log.d(TAG, "onComplete: info ghaltin hhh ");
                                        Toast.makeText(LoginActivity.this, "les informations sont incorrect", Toast.LENGTH_SHORT).show();
                                        editTextEmailLogin.requestFocus();
                                        return;
                                }
                                } else {
                                    progressBarLoading.setVisibility(View.INVISIBLE);
                                    Toast.makeText(LoginActivity.this, "il ya un problem", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressBarLoading.setVisibility(View.INVISIBLE);
                                Toast.makeText(LoginActivity.this, "il ya un problem", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        });

            }
        });
    }
}