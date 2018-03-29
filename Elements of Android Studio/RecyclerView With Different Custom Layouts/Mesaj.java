package com.example.keremoflu.chatcustom.Model;

/**
 * Created by Kerem Oflu on 28.03.2018.
 */

public class Mesaj {
    private String message;
    private int type;

    public static final int ADMIN_TYPE = 1;
    public static final int USER_TYPE = 2;

    public Mesaj(String message, int type) {
        this.message = message;
        this.type = type;
    }

    public Mesaj(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
