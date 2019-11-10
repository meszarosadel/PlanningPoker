package com.example.planningpoker;

import java.util.ArrayList;

public class Developer {

    public static final String TABLE_NAME = "developers";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DEVELOPER = "developer";
    public  static final String COLUMN_PASSWORD = "password";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DEVELOPER + " TEXT,"
            + COLUMN_PASSWORD + " TEXT"
            + ")";

    private int id;
    private String developer;
    private String password;

    public Developer(){
    }

    public  Developer(int id, String developer, String password){
        this.id = id;
        this.developer = developer;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }



}
