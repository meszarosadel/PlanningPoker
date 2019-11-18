package com.example.planningpoker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME =  "scrum_db";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(Developer.CREATE_TABLE);
        db.execSQL(Task.CREATE_TABLE);
        db.execSQL(Task.MIGRATE_TABLE);

    }

    public void onCreateVote(SQLiteDatabase db){
        db.execSQL(Task.CREATE_TABLE);
        db.execSQL(RatingTasks.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + Developer.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Task.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RatingTasks.TABLE_NAME);
        onCreate(db);
    }

    public long insertDeveloper ( String developer, String password ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Developer.COLUMN_DEVELOPER, developer);
        values.put(Developer.COLUMN_PASSWORD, password);
        long id = db.insert(Developer.TABLE_NAME,null, values);
        db.close();
        return id;
    }

    public long insertTask ( String task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Task.COLUMN_TASK, task);
        long id = db.insert(Task.TABLE_NAME,null, values);
        db.close();
        return id;
    }

    public long insertRatingTasks(String rate, long developer_id, long task_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RatingTasks.COLUMN_PART, rate);
        values.put(RatingTasks.COLUMN_DEVELOPER_ID, developer_id);
        values.put(RatingTasks.COLUMN_TASK_ID, task_id);
        long id = db.insert(RatingTasks.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public Developer getDeveloper(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Developer.TABLE_NAME,
                new String[]{Developer.COLUMN_ID, Developer.COLUMN_DEVELOPER},
                Developer.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if( cursor != null)
            cursor.moveToFirst();

        Developer developer = new Developer(
                cursor.getInt(cursor.getColumnIndex(Developer.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Developer.COLUMN_DEVELOPER)),
                cursor.getString(cursor.getColumnIndex(Developer.COLUMN_PASSWORD)));
        cursor.close();
        return developer;
    }

    public Task getTask(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Task.TABLE_NAME,
                new String[]{Task.COLUMN_ID, Task.COLUMN_TASK},
                Task.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if( cursor != null)
            cursor.moveToFirst();

        Task task = new Task(
                cursor.getInt(cursor.getColumnIndex(Task.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Task.COLUMN_TASK)));
        cursor.close();
        return task;
    }
    public Cursor getTasks() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+Task.TABLE_NAME,null);
        return res;
    }
    //public RatingTasks getRatingTasks(long id){}

}
