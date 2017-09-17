package com.example.asim.customlistview.Login_Register_Profile.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asim.customlistview.DatabaseHandler;
import com.example.asim.customlistview.Login_Register_Profile.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalit on 9/12/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "DuskySolution.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private static final String COLUMN_CHANGE_PASSWORD = "new_password";

    /**
     * Constructor
     * 
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT"  + COLUMN_CHANGE_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();


//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;

        //Table to query


       //columns to return  //columns for the WHERE clause   //The values for the WHERE clause   //group the rows   //filter by row groups   //The sort order

        Cursor cursor = db.query(TABLE_USER , columns ,null, null, null, null, sortOrder);





        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                //user.setnewPassword(cursor.getString(cursor.getColumnIndex(COLUMN_CHANGE_PASSWORD)));
                // Adding user record to list

                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

     //This method to update user record

    public Boolean updatePasswords(String strEmailOld , String strEmailNew)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_PASSWORD,strEmailNew);

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_PASSWORD + " = ?", new String[]{String.valueOf(strEmailNew)});
        db.close();


        return true;
    }




//    public String updatePassword(User user)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(COLUMN_USER_PASSWORD, user.getPassword());
//        values.put(COLUMN_USER_NAME, user.getName());
//
//
//
//        //values.put(COLUMN_USER_EMAIL, user.getEmail());
//        //values.put(COLUMN_CHANGE_PASSWORD, user.getnewPassword());
//
//        // updating row
//        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?", new String[]{String.valueOf(user.getPassword())});
//        db.close();
//
//        return null;
//    }





    public Boolean  updatePassword(Boolean name , Boolean password)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cur=db.rawQuery("UPDATE "+TABLE_USER +" SET " + COLUMN_USER_PASSWORD+ " = '"+password+"' WHERE "+ COLUMN_USER_NAME +"=?", new String[]{String.valueOf(name)});

        if (cur != null)
        {
            if(cur.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }






//     This method is to delete user record

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }


//     This method to check user exist or not

    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {COLUMN_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};


/*//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'zainkalim92@gmail.com';         */
        //Table to query


            //columns to return  //columns for the WHERE clause  //The values for the WHERE clause   //group the rows    //filter by row groups


        Cursor cursor = db.query(TABLE_USER, columns , selection,selectionArgs,null,null,null);
        //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        return cursorCount > 0;

    }

//      This method to check user exist or not

    public boolean checkUser(String name , String email, String password)
    {

        // array of columns to fetch
        String[] columns = {COLUMN_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?"  + " AND " + COLUMN_USER_NAME + " = ?";

        // selection arguments
        String[] selectionArgs = {name , email, password};


//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'zainkalim92@gmail.com' AND user_password = 'qwerty';*/

         //columns to return  //columns for the WHERE clause //The values for the WHERE clause //group the rows //filter by row groups //The sort order
        Cursor cursor = db.query(TABLE_USER, columns , selection,selectionArgs,null,null,null);


        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        return cursorCount > 0;

    }

    public DatabaseHelper open() throws SQLException
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return this;
    }
    public void close()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.close();
    }
}
