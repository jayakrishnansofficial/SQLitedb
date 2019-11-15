package com.example.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

//
//    public static final String DATABASE_NAME = "mydatabase";
//    public static final String TABLE_NAME = "table";
//    public static final int DATABASE_Version = 1;
//    public static final String UID = "_id";
//    public static final String NAME = "name";
//    public  static final String PASSWORD = "password";
//
//    public static final String CREATE_TABLE = " CREATE TABLE " +TABLE_NAME+ "(" +UID+ "INTEGER PRIMAER KEY AUTOINCREMENT ,"
//            +NAME+ "VARCHAR(255) ," +PASSWORD+ "VARCHAR(255));";
//
//    public static final String DROP_TABLE = "DROP TABLE IF EXIST " +TABLE_NAME;
//
//
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, DATABASE_NAME, null, 1);
//        this.context = context;
//
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//      try {
//          db.execSQL(CREATE_TABLE);
//      }catch (Exception e){
//          Toast.makeText(context,"",Toast.LENGTH_SHORT).show();
//      }
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        try {
//            db.execSQL(DROP_TABLE);
//            onCreate(db);
//            Toast.makeText(context,"upgrade",Toast.LENGTH_SHORT).show();
//        }catch (Exception e){
//            Toast.makeText(context,"",Toast.LENGTH_SHORT).show();
//        }
//
//    }

    public static final String DATABASE_NAME = "mydatabase";   //database name
    public static final String TABLE_NAME = "mytable";  // table name
    public static final int DATABASE_Version = 1;   // Database Version
    public static final String UID = "_id"; //Column 1 (Primary key)
    public static final String NAME = "name"; //Column 2
    public static final String PASSWORD = "password"; //Column 3

                                        //FIRST//
    ///++++++++++++++++++++++++++++++CREATING TABLE+++++++++++++++++++++++++++++++++++++//

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + "  INTEGER PRIMARY KEY AUTOINCREMENT ," + NAME + " VARCHAR(255) , " + PASSWORD + " VARCHAR(255));";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public final Context context;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Toast.makeText(context, "", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context, "ON UPGRADE", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
        }

    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//




}
