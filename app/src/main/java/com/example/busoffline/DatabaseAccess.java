package com.example.busoffline;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null)
            instance = new DatabaseAccess(context);
        return instance;
    }

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
       if(db!=null)
           this.db.close();
    }

    Cursor getBusData(String sourcename,String destname){
        // %sourcename%destinationname%
        c=db.rawQuery("select BUS_NAME,ROUTE_START,ROUTE_END,ROUTE_MAP from BusesData where ROUTE_MAP like  '%"+sourcename+"%"+destname+"%'",new String[]{});
//
//        }
        return c;
    }
}
