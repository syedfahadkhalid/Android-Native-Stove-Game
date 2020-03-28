package com.barcode.com.cookingstove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBhandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "CookingStoveDB";
    // Contacts table name
    private static final String TABLE_FOODS= "foods";
    // Shops Table Columns names
    public static final String KEY_ID = "FoodId";
    public static final String KEY_NAME = "nameofcook";
    private static final String KEY_TIME = "time";
    private static final String KEY_TEMP = "tempreature";




    public DBhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_FOODS + "("
        + KEY_ID + " INTEGER PRIMARY KEY   AUTOINCREMENT," + KEY_NAME + " TEXT,"
        + KEY_TEMP + " INTEGER," +KEY_TIME+ " INTEGER"+ ");";
        db.execSQL(CREATE_CONTACTS_TABLE);
        db.execSQL("INSERT INTO foods (time,nameofcook,tempreature) VALUES (1 ,'water boiling',100);");
        db.execSQL("INSERT INTO foods (time,nameofcook,tempreature) VALUES (12,'Boiled eggs',100);");
        db.execSQL("INSERT INTO foods (time,nameofcook,tempreature) VALUES (20,'Rice',180);");
        db.execSQL("INSERT INTO foods (time,nameofcook,tempreature) VALUES (15,'Pasta',170);");
        db.execSQL("INSERT INTO foods (time,nameofcook,tempreature) VALUES (5,'Fried potatoes',190);");
        db.execSQL("INSERT INTO foods (time,nameofcook,tempreature) VALUES (20,'Fish',180);");
        db.execSQL("INSERT INTO foods (time,nameofcook,tempreature) VALUES (30,'Chiken',180);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);
// Creating tables again
        onCreate(db);
    }

    // Adding new shop
    public void addFood(Food food) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, food.getName()); // Shop Name
         // Shop Phone Number
        values.put(KEY_TIME,food.getTime());
        values.put(KEY_TEMP, food.getTemp());
// Inserting Row
        db.insert(TABLE_FOODS, null, values);
        db.close(); // Closing database connection
    }
    // Getting one shop
    public Food getFood(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOODS, new String[]{KEY_ID,
                KEY_NAME,KEY_TEMP,KEY_TIME}, KEY_ID + "=?",
        new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Food contact = new Food(Integer.parseInt(cursor.getString(3)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
// return shop
        return contact;
    }
    // Getting All Shops
    public List<Food> getAllFoods() {
        List<Food> shopList = new ArrayList<Food>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_FOODS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Food food = new Food();
                food.setTemp(Integer.parseInt(cursor.getString(0)));
                food.setName(cursor.getString(1));
                food.setTime(Integer.parseInt(cursor.getString(2)));
// Adding contact to list
                shopList.add(food);
            } while (cursor.moveToNext());
        }

// return contact list
        return shopList;
    }
    // Getting shops Count
    public int getFoodsCount() {
        String countQuery = "SELECT * FROM " + TABLE_FOODS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

// return count
        return cursor.getCount();
    }
    // Updating a shop
    public int updateShop(Food food) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, food.getName());
        values.put(KEY_TEMP, food.getTemp());

        values.put(KEY_TIME, food.getTime());
// updating row
        return db.update(TABLE_FOODS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(food.getId())});
    }

    // Deleting a shop
    public Cursor getAllRows(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =db.rawQuery( "select FoodId _id,* from foods", null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
