package com.burhangok.doguyemekleri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class LocalDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME="burhangok";

    public static final String TABLE_NAME="foods";

    public LocalDatabase(Context context) {


        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCumlesi = "CREATE TABLE "+TABLE_NAME+" (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT," +
                " photo TEXT," +
               " materials INTEGER," +
                " cooking TEXT" + ")";
        db.execSQL(sqlCumlesi);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<FoodItem> getFoods () {

        List<FoodItem> foodItemArrayList = new ArrayList<FoodItem>();

        SQLiteDatabase vt = this.getWritableDatabase();

        String sqlCumlesi = "SELECT * FROM " +TABLE_NAME;


        Cursor cursor = vt.rawQuery(sqlCumlesi,null);

        while (cursor.moveToNext()) {

            FoodItem foodItem = new FoodItem();

            foodItem.setTitle(cursor.getString(1));
            foodItem.setPhoto(Integer.parseInt(cursor.getString(2)));
            foodItem.setMaterials(cursor.getString(3));
            foodItem.setCooking(cursor.getString(4));

            foodItemArrayList.add(foodItem);


        }

        return foodItemArrayList;
    }



    public void addFood (FoodItem foodItem) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title",foodItem.getTitle());
        contentValues.put("photo",foodItem.getPhoto());
        contentValues.put("materials",foodItem.getMaterials());
        contentValues.put("cooking",foodItem.getCooking());

        db.insert(TABLE_NAME,null,contentValues);
        db.close();

    }




}