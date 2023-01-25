package com.example.mad_practical_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class employeedbhelper {
    public  static final String empid = "empid";
    public  static final String empname="empname";
    public  static final String emppassword="emppassword";

    public  static final String databasename="edb";
    public  static final String tablename="employee";
    public  static final int databaseversion=1;

    public static final String createtable = "create table employee ( empid integer primary key autoincrement ,"+
                                               "empname text not null , emppassword text not null) ";

    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    Context ct;

    public employeedbhelper(Context context) {
        this.ct=context;
        databaseHelper=new DatabaseHelper(ct);
    }


    private class DatabaseHelper  extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, databasename,null, databaseversion);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
                              sqLiteDatabase.execSQL(createtable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS employee");

        }



    }

    public  employeedbhelper  connect(){
      sqLiteDatabase=databaseHelper.getWritableDatabase();
      return this;
    }

    public  void disconnect(){
        databaseHelper.close();
    }

    public  void insertdata(String username, String epassword){

        ContentValues contentValues=new ContentValues();
        contentValues.put(empname,username);
        contentValues.put(emppassword,epassword);

        this.connect();
        sqLiteDatabase.insert(tablename,null,contentValues);

    }

    public Cursor retrivealldata(){
        this.connect();
     return    sqLiteDatabase.query(tablename,new String[]{empid,empname,emppassword},null,null,
                              null,null,null);


    }
    public  Cursor retriveaemployee(int id){
        this.connect();
        Cursor c= sqLiteDatabase.query(true,tablename,new String[]{empid,empname,emppassword},empid +"=" + id ,
                                         null,null,null,null,null);
            if (c!=null){
                c.moveToFirst();
            }
            return  c;
    }

}
