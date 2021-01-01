package com.example.myapplication2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.prefs.PreferencesFactory

class SqlDbHelper(context: Context, databaseName:String, factory: SQLiteDatabase.CursorFactory?, version:Int): SQLiteOpenHelper(context, databaseName, factory, version) {

    override fun onCreate(database: SQLiteDatabase?){
        database?.execSQL("create table if not exists UsersTable (id text primary key, userName text, userId text, passWord int)")
    }
    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion) {
            database?.execSQL("alter table UsersTable add column deleteFlag integer default 0")
        }
    }
}