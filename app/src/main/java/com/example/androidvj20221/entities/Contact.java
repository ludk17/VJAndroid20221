package com.example.androidvj20221.entities;

public class Contact {
    public int id;
    public String name;
    public String number;
    public String avatar;


    public Contact() {
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Contact(int id, String name, String number, String avatar) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.avatar = avatar;
    }
}
