package com.example.noteretrieve

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import android.widget.Toast

class dbhelper(context: Context) :SQLiteOpenHelper(context,"notes1.db",null,1){
   var sqLiteDatabase:SQLiteDatabase=writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
       if (db !=null){
           db.execSQL("create table notes (note text)")
       }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) { }
    fun addNote(note:String){

        val cv=ContentValues()
        cv.put("note",note)
        sqLiteDatabase.insert("notes",null,cv)
    }

    @SuppressLint("Range")
    fun retriveNote(note:String):String{
        var c: Cursor =sqLiteDatabase.query("notes",null,"note=?",
            arrayOf(note),null,null,null)
        c.moveToFirst()
        if(c != null && c.moveToFirst()){
        var retriveN=c.getString(c.getColumnIndex("note"))
            return retriveN
    }else{

       Log.d("NoNote","NoNote")
    }
    return " "
    }

}