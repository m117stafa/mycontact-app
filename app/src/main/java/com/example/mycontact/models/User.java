package com.example.mycontact.models;

public class User {

    private String emailUser;
    private String numUser;
    private String motPass;

    private String nomUser;
    private String prenomUser;

    public User() {
    }

    public User(String emailUser, String numUser, String motPass, String nomUser, String prenomUser) {
        this.emailUser = emailUser;
        this.numUser = numUser;
        this.motPass = motPass;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
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
