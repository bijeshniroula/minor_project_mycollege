package com.example.bijesh.mycollege10;

import java.io.Serializable;

/**
 * Created by Bijesh on 8/5/2015.
 */
public class Colleges implements Serializable{
    String name,address,faculties,contact,details,websites,facebook;

    public Colleges ( String name, String address, String faculties, String contact, String details,String websites,String facebook) {
        this.name = name;
        this.address = address;
        this.faculties = faculties;
        this.contact = contact;
        this.details= details;
        this.websites =  websites;

        this.facebook = facebook;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getWebsites(){
        return websites;
    }

    public void setWebsites(String websites){
        this.websites = websites;
    }

    public String getFaculties(){
        return faculties;
    }

    public void setFaculties(String faculties){
        this.faculties = faculties;
    }

    public String getFacebook(){
        return facebook;
    }

    public void setFacebook(String facebook){
        this.facebook = facebook;
    }



}
