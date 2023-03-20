package com.example.mycontact.models;

import java.util.ArrayList;

public class User {

    private String emailUser;
    private String numUser;
    private String motPass;

    private String nomUser;
    private String prenomUser;

    private ArrayList<Contact> listContactUser;

    public User() {
    }

    public User(String emailUser, String numUser, String motPass, String nomUser, String prenomUser) {
        this.emailUser = emailUser;
        this.numUser = numUser;
        this.motPass = motPass;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
    }

    public User(String emailUser, String numUser, String motPass, String nomUser, String prenomUser,ArrayList<Contact> listContactUser) {
        this.emailUser = emailUser;
        this.numUser = numUser;
        this.motPass = motPass;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.listContactUser = listContactUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNumUser() {
        return numUser;
    }

    public ArrayList<Contact> getListContactUser() {
        return listContactUser;
    }

    public void setListContactUser(ArrayList<Contact> listContactUser) {
        this.listContactUser = listContactUser;
    }

    public void setNumUser(String numUser) {
        this.numUser = numUser;
    }

    public String getMotPass() {
        return motPass;
    }

    public void setMotPass(String motPass) {
        this.motPass = motPass;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }
}
