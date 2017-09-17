package com.example.asim.customlistview;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;


public class DatabaseHandler extends SQLiteOpenHelper
{

    public DatabaseHandler(Context context, Object name, Object factory, int version)
    {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }




        public DatabaseHandler(Context context)
    {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }




    private String password;
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Mydatabase.db";

    // Contacts table name
    private static final String TABLE_REGISTER= "register";
    public static final String KEY_ID = "_id";
    public static final String KEY_FIRST_NAME = " first_name";
    public static final String KEY_EMAIL_ID="email_id";
    public static final String KEY_CONFIRM_PASSWORD = "confirm_password";
    public static final String KEY_PASSWORD = "password";
    public static final String NEW_PASSWORD = "repassword";



     public static final String CREATE_TABLE="CREATE TABLE " + TABLE_REGISTER + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
        + KEY_FIRST_NAME + " TEXT," + KEY_EMAIL_ID + " TEXT," + KEY_CONFIRM_PASSWORD + " TEXT," + KEY_PASSWORD + " TEXT," + NEW_PASSWORD +" TEXT, " + ")";




    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // TODO Auto
        // -generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);
    }

    void addregister(Registerdata registerdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,registerdata.getID());
        values.put(KEY_FIRST_NAME,registerdata.getfirstName()); // register first Name
        values.put(KEY_EMAIL_ID, registerdata.getEmailId());  //register email id
        values.put(KEY_CONFIRM_PASSWORD, registerdata.getConfirm_password());  //register mobile no
        values.put(KEY_PASSWORD, registerdata.getPassword());
        values.put(NEW_PASSWORD, registerdata.getChangePassword());

        // Inserting Row
        db.insert(TABLE_REGISTER, null, values);
        db.close(); // Closing database connection
    }









    public void insertEntry(String password,String repassword)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PASSWORD, password);
        values.put(NEW_PASSWORD, repassword);

        db.insert(TABLE_REGISTER, null, values);
    }


    public int deleteEntry(String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String where="KEY_PASSWORD=?";
        int numberOFEntriesDeleted= db.delete(TABLE_REGISTER, where, new String[]{password}) ;
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.query(TABLE_REGISTER, null, " KEY_PASSWORD=?", new String[]{password}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String repassword= cursor.getString(cursor.getColumnIndex(NEW_PASSWORD));
        cursor.close();
        return repassword;
    }


    public String getAllTags(String a)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + "register" + " where repassword = '" +a + "'" , null);
        String str = null;
        if (c.moveToFirst()) {
            do {
                str = c.getString(c.getColumnIndex(NEW_PASSWORD));
            } while (c.moveToNext());
        }
        return str;
    }





    //code to get the register
    String update(String password , String repassword){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{password},null, null, null, null);

        if(cursor.getCount()<1)
        {
            cursor.close();
            return "Not Exist";
        }

        else if(cursor.getCount()>=1 && cursor.moveToFirst())
        {

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }

        else if(cursor.getCount()>=2 && cursor.moveToFirst())
        {

            password = cursor.getString(cursor.getColumnIndex(NEW_PASSWORD));
            cursor.close();

        }

        return password;
    }











//    public boolean updateEntry(String password , String repassword )
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//
//        ContentValues updatedValues = new ContentValues();
//
//       // updatedValues.put(KEY_FIRST_NAME , username);
//        updatedValues.put(KEY_PASSWORD, password);
//        updatedValues.put(NEW_PASSWORD, repassword);
//
//        String where="KEY_PASSWORD =?";
//        db.update(TABLE_REGISTER,updatedValues, where, new String[]{password});
//
//        return true;
//    }




//    public String updateEntry(Registerdata registerdata)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues updatedValues = new ContentValues();
//        updatedValues.put(KEY_PASSWORD, registerdata.getPassword());
//        updatedValues.put(NEW_PASSWORD, registerdata.getChangePassword());
//
//        String where="NEW_PASSWORD = ?";
//        db.update(TABLE_REGISTER,updatedValues, NEW_PASSWORD, new String[]{registerdata.getChangePassword()});
//
//        return NEW_PASSWORD;
//    }


    public HashMap<String, String> getAnimalInfo(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        HashMap<String, String> wordList = new HashMap<String, String>();
        String selectQuery = "SELECT * FROM register where KEY_PASSWORD='"+id+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                wordList.put("KEY_PASSWORD", cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return wordList;
    }













    //code to get the register
    String getregister(String username){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);

        if(cursor.getCount()<1)
        {
            cursor.close();
            return "Not Exist";
        }

        else if(cursor.getCount()>=1 && cursor.moveToFirst())
        {

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }

        return password;
    }


    public String getDatabaseName()
    {
        return DATABASE_NAME;
    }

    public static String getKeyId()
    {
        return KEY_ID;
    }

    public static String getTableContacts()
    {
        return TABLE_REGISTER;
    }

    public static int getDatabaseVersion()
    {
        return DATABASE_VERSION;
    }



    public DatabaseHandler open() throws SQLException
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