package com.example.planningpoker;

import java.util.ArrayList;

public class Developer {

    public static final String TABLE_NAME = "developers";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DEVELOPER = "developer";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DEVELOPER + " TEXT"
            + ")";

    private int id;
    private String developer;

    public Developer(){
    }

    public  Developer(int id, String developer){
        this.id=id;
        this.developer=developer;
    }

    public int getId() {
        return id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }



}
