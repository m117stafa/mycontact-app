package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailContactActivity extends AppCompatActivity {

    ImageView profileImage;
    TextView nameProfil, phoneProfil, emailProfil, serviceProfil;

    ImageView iconPhonecall, iconSMS, iconEmail, iconShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        profileImage = findViewById(R.id.profilImageDetails);
        nameProfil = findViewById(R.id.nameProfilDetails);
        phoneProfil = findViewById(R.id.phoneProfilDetails);
        emailProfil = findViewById(R.id.emailProfilDetails);
        serviceProfil = findViewById(R.id.serviceProfilDetails);

        iconPhonecall = findViewById(R.id.iconPhonecall);
        iconSMS = findViewById(R.id.iconSMS);
        iconEmail = findViewById(R.id.iconEmail);
        iconShare = findViewById(R.id.iconShare);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            nameProfil.setText(bundle.getString("nom"));
            phoneProfil.setText(bundle.getString("phone"));
            emailProfil.setText(bundle.getString("email"));
            serviceProfil.setText(bundle.getString("service"));
            //profileImage.setImageResource(bundle.getString("image"));
        }



    }
}