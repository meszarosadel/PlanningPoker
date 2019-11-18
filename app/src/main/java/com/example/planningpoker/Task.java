package com.example.planningpoker;

public class Task {

    public static final String TABLE_NAME = "tasks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TASK = "task";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TASK + " TEXT"
            + ")";
    public static final String MIGRATE_TABLE = "INSERT INTO " + TABLE_NAME + " VALUES (1,'TASK1'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (2,'TASK2'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (3,'TASK3'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (4,'TASK4'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (5,'TASK5'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (6,'TASK6'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (7,'TASK7'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (8,'TASK8'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (9,'TASK9'); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (10,'TASK10'); ";

    private int id;
    private String task;

    public Task(){
    }

    public  Task(int id, String task){
        this.id=id;
        this.task=task;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
