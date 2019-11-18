package com.example.planningpoker;

public class RatingTasks {

    private int developer_id;
    private int task_id;
    private int  part;

    public static final String TABLE_NAME = "ratingTasks";
    public static final String COLUMN_DEVELOPER_ID = "developer_id";
    public static final String COLUMN_TASK_ID = "task_id";
    public static final String COLUMN_PART = "part";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "("
            + COLUMN_DEVELOPER_ID + " INTEGER, "
            + COLUMN_TASK_ID + " INTEGER, "
            + COLUMN_PART + " INTEGER, PRIMARY KEY ("
            + COLUMN_DEVELOPER_ID + "," + COLUMN_TASK_ID + "))";
    public static final String MIGRATE_TABLE = "INSERT INTO " + TABLE_NAME + " VALUES (1,1,1); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (2,2,2); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (3,3,3); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (4,4,4); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (5,5,5); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (6,6,6); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (7,7,7); "
            +  "INSERT INTO " + TABLE_NAME + " VALUES (8,8,8); ";

    public RatingTasks(){
    }

    public RatingTasks( int developer_id, int task_id,int part){
        this.developer_id = developer_id;
        this.task_id = task_id;
        this.part = part;
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
