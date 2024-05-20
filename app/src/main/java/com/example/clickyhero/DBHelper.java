package com.example.clickyhero;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context) {
        this(context, "dbClickyHero", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTblQuery = "";
        createTblQuery = "CREATE TABLE tblCombos " +
                "( " +
                "comboID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "comboName TEXT, " +
                "sequence TEXT, " +
                "comboSize INTEGER, " +
                "isCompleted INTEGER, " +
                "isCorrect INTEGER" +
                ")";

        String insertTblQuery = "";
        insertTblQuery = "INSERT INTO tblCombos " +
                "(comboName, sequence, comboSize, isCompleted, isCorrect) " +
                "VALUES " +
                "('Cheetah Sprint', 'RRUR', 4, -1, -1), " +
                "('Cheetah Jump', 'LUUDL' , 5, -1, -1), " +
                "('Cheetah Backflip', 'ULLD', 4, -1, -1), " +
                "('Cheetah Dive', 'DDRD', 4, -1, -1), " +
                "('Cheetah Zap', 'UDURLR', 6, -1, -1);";

        db.execSQL(createTblQuery);
        db.execSQL(insertTblQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public ArrayList<Combo> getAllCombos() {
//
//        ArrayList<Combo> allCombos = new ArrayList<>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor resultSet = db.query("tblCombos", null, null, null, null, null, null);
//
//        while (resultSet.moveToNext()) {
//
//            Combo combo = new Combo();
//
//            combo.setComboID(resultSet.getInt(0));
//            combo.setComboName(resultSet.getString(1));
//            combo.setSequence(resultSet.getString(2));
//            combo.setComboSize(resultSet.getInt(3));
//            combo.setIsCompleted(resultSet.getInt(4));
//            combo.setIsCorrect(resultSet.getInt(5));
//
//            allCombos.add(combo);
//        }
//
//        Collections.shuffle(allCombos);
//
//        return allCombos;
//    }
}
