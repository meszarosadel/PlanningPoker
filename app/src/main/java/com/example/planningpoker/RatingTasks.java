package com.example.planningpoker;

public class RatingTasks {

    private int id;
    private int developer_id;
    private int task_id;
    private int  part;

    public static final String TABLE_NAME = "ratingTasks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DEVELOPER_ID = "developer_id";
    public static final String COLUMN_TASK_ID = "task_id";
    public static final String COLUMN_PART = "part";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "("
            + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DEVELOPER_ID + " INTEGER, "
            + COLUMN_TASK_ID + " INTEGER, "
            + COLUMN_PART + " INTEGER, "
            + "FOREIGN KEY ( " + COLUMN_TASK_ID + ") REFERENCES tasks(id),"
            + "FOREIGN KEY ( " + COLUMN_DEVELOPER_ID + ") REFERENCES developers(id))";

    public RatingTasks(){
    }

    public RatingTasks(int id, int developer_id, int task_id,int part){
        this.id = id;
        this.developer_id = developer_id;
        this.task_id = task_id;
        this.part = part;
    }

    public int getId() {
        return id;
    }

    public int getDeveloper_id() {
        return developer_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public int getPart() {
        return part;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setPart(int part) {
        this.part = part;
    }
}
