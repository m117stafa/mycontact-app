package com.example.mycontact.models;

public class Contact {

    private String nomContact;
    private String prenomContact;
    private String serviceContact;
    private String emailContact;
    private String telContact;
    private String imgUrl;

    public Contact() {

    }

    public Contact(String nomContact, String prenomContact, String serviceContact,
                   String emailContact, String telContact, String imgUrl) {
        this.nomContact = nomContact;
        this.prenomContact = prenomContact;
        this.serviceContact = serviceContact;
        this.emailContact = emailContact;
        this.telContact = telContact;
        this.imgUrl = imgUrl;
    }

    public String getNomContact() {
        return nomContact;
    }

    public String getPrenomContact() {
        return prenomContact;
    }

    public String getServiceContact() {
        return serviceContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public String getTelContact() {
        return telContact;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public void setPrenomContact(String prenomContact) {
        this.prenomContact = prenomContact;
    }

    public void setServiceContact(String serviceContact) {
        this.serviceContact = serviceContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public void setTelContact(String telContact) {
        this.telContact = telContact;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
