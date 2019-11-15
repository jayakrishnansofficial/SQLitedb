package com.example.sqlitedb;

import android.app.Notification;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

        //SECOND//

   public class DatabaseAdapter {


       DatabaseHelper databaseHelper;

       public DatabaseAdapter(Context context) {
          databaseHelper = new DatabaseHelper(context);
       }


       public long insertdata(String name , String password){
           SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
           ContentValues contentValues = new ContentValues();
           contentValues.put(DatabaseHelper.NAME,name);
           contentValues.put(DatabaseHelper.PASSWORD,password);
           long id  = sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
           return id;

       }





       //
//     DatabaseHelper databaseHelper;
//
//     public DatabaseAdapter(Context context) {
//         databaseHelper = new DatabaseHelper(context);
//     }
//
//
//          //+++++++++++++++++++++INSERTING DATA TO TABLE QUERY +++++++++++++++++++++++++//
//
//     public long insertData(String name, String password) {
//         SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
//         ContentValues contentValues = new ContentValues();
//         contentValues.put(DatabaseHelper.NAME, name);
//         contentValues.put(DatabaseHelper.PASSWORD, password);
//         long id = sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
//         return id;
//
//     }
//
//                                     //++++++++++++++++++++++++//



//

public String getdata(){
           SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
           String[] column = {DatabaseHelper.UID,DatabaseHelper.NAME,DatabaseHelper.PASSWORD};
           Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME,column,null,null,null,null,null);

           StringBuffer stringBuffer = new StringBuffer();
           while (cursor.moveToNext()){
               int columnid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.UID));
               String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAME));
               String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PASSWORD));
               stringBuffer.append(columnid + " " + name + " " + password + "\n");
           }
           return stringBuffer.toString();
}


//     //+++++++++++++++++++++++++++++++++++++ GET DATA ++++++++++++++++++++++++++++++++++++++//
//
//
//     public String getData() {
//         //make it writable
//         SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
//         String[] columns = {DatabaseHelper.UID, DatabaseHelper.NAME, DatabaseHelper.PASSWORD};
//         //Cursor is used to take line by line data in row
//         Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
//
//         StringBuffer stringBuffer = new StringBuffer();
//         while (cursor.moveToNext()) {
//             int columnid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.UID));
//             String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAME));
//             String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PASSWORD));
//             stringBuffer.append(columnid + " " + name + " " + password + " " + "\n");
//         }
//         return stringBuffer.toString();
//
//     }
//
//                                    //+++++++++++++++++++++++++++++//

       public  int delete(String username){
           SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
           String[] whereArgs = {username};
           int count = sqLiteDatabase.delete(DatabaseHelper.TABLE_NAME,DatabaseHelper.NAME + " = ? " , whereArgs);
           return count;

       }
//
//
//                  //+++++++++++++++++++++++ DELETE DATA ++++++++++++++++++++++++++++//
//
//
//     public int delete(String username) {
//         SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
//         String[] whereArgs = {username};
//
//         int count = sqLiteDatabase.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.NAME + " = ?", whereArgs);
//         return count;
//
//     }
//
//                                    //+++++++++++++++++++++++++++++++++//





       public  int updatename(String oldname , String newname){
           SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
           ContentValues contentValues = new ContentValues();
           contentValues.put(DatabaseHelper.NAME,newname);
           String[] whereArgs = {oldname};
           int count = sqLiteDatabase.update(DatabaseHelper.TABLE_NAME,contentValues,DatabaseHelper.NAME + " =? ",whereArgs);
           return count;

       }
//
//
//                        // ++++++++++++++++++++++++++++UPDATE++++++++++++++++++++++++++++++//
//
//
//     public int updatename(String oldname, String newname) {
//
//         {
//             SQLiteDatabase db = databaseHelper.getWritableDatabase();
//             ContentValues contentValues = new ContentValues();
//             contentValues.put(DatabaseHelper.NAME, newname);
//             String[] whereArgs = {oldname};
//             int count = db.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.NAME + " = ?", whereArgs);
//             return count;
//         }
//
//     }
//                                             //+++++++++++++++++++++++++++//



 }