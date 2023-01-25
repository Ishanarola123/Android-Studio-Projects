package com.example.extra_database_practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class employeedbhelper {
    public  static final String empid = "empid";
    public  static final String empname="empname";
    public  static final String empsalary="empsalary";

    public  static final String databasename="employeedb";
    public  static final String tablename="employee";
    public  static final int databaseversion=1;



    public static final String create_table = "create table employee ( empid integer primary key autoincrement , " +
            "empname text not null, empsalary integer not null) ";
    private Context ct;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

public  employeedbhelper(Context context){
    this.ct=context;
    databaseHelper=new DatabaseHelper(ct);

}
    private class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context) {
            super(context,databasename,null,databaseversion);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try{
                sqLiteDatabase.execSQL(create_table);
            }
            catch (SQLException sqlException){
   sqlException.printStackTrace();

            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("DROP TABLE IF EXISTS employee");

        }
    }
 public    employeedbhelper connect() throws  SQLException{
     sqLiteDatabase=databaseHelper.getWritableDatabase();
     return this;
 }
 public void disconnect() throws SQLException{
    databaseHelper.close();
 }

public long insertemployeedata( String empname, int esalary){
    ContentValues cv=new ContentValues();
    cv.put("empname",empname);
    cv.put("empsalary" , esalary);
    this.connect();
    return sqLiteDatabase.insert(tablename,null,cv);

}
public Cursor retrivealldata(){
this.connect();
//retrive all data
    return sqLiteDatabase.query(tablename,new String[]{empid,empname,empsalary},
            null,null,null,null,null);

}
public Cursor retriveadata(long id){
    this.connect();
    Cursor c=sqLiteDatabase.query(true,tablename,new String[]{empid,empname,empsalary},empid +"="+

            id ,null,null,null,null,null);
    if (c!=null){
c.moveToFirst();
    }
    return  c;
}

}
