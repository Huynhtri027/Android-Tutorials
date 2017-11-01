package com.example.kerem.veritabaniornekuygulama1;



public class Student {

    private String nameSurname;
    private String email;
    private String adress;

    public Student(){

    }

    public Student(String nameSurname, String email, String adress){
        this.nameSurname=nameSurname;
        this.email=email;
        this.adress=adress;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
