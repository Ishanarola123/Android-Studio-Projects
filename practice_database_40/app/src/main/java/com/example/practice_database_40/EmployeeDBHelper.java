package com.example.practice_database_40;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EmployeeDBHelper {

    public static final String Empid="Empid";
    public static final String EmpName = "EmpName";
    public static final String EmpSal = "EmpSal";
    public static final String databasename = "EmployeeDB";
    public static final String tablename = "Employee";
    public static final int databaseversion = 1;

    public static final String create_table = "create table employee(Empid integer primary key autoincrement , " +
            "EmpName text not null, Empsal integer not null)";

    private Context ct;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;


//make constructor of EmployeeDBHelper class
   public  EmployeeDBHelper(Context context){
       this.ct=context;
       dbHelper= new DatabaseHelper(ct);
   }

    //inherient
    private  static  class   DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context c) {
            super(c,databasename,null, databaseversion);

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }


}
