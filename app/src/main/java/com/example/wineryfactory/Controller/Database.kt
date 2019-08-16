package com.example.wineryfactory.Controller

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


private val DATABASE_NAME = "League"
private val DATABASE_VERSION = 1
private val TABLE_NAME = "jogador"
private val TABLE_NAME2 = "time"
private val TABLE_NAME3 = "campeonato"


class Database (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL(
            "create table if not exists $TABLE_NAME3 ("+
                    "id integer PRIMARY KEY AUTOINCREMENT," +
                    "nome text," +
                    "descricao text," +
                    "regras text," +
                    "inicio text," +
                    "fim text)"
        )

        db!!.execSQL(
            "create table if not exists $TABLE_NAME2 ("+
                    "id integer PRIMARY KEY AUTOINCREMENT," +
                    "nome text)"
        )

        db!!.execSQL(
            "create table if not exists $TABLE_NAME ("+
                    "id integer PRIMARY KEY AUTOINCREMENT," +
                    "nome text," +
                    "nick text," +
                    "email text," +
                    "funcao text," +
                    "telefone text)"
        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}