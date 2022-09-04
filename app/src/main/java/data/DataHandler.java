/**
 A class which inherit the SQLiteOpenHelper class
 --> To perform all the SQL operations which we can use when we need
 */
package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import modle.Contact;
import parameters.Param;

public class DataHandler extends SQLiteOpenHelper {

    /** Providing context of the database to the Class*/
    public DataHandler(Context context)
    {
        super(context, Param.DB_NAME, null, Param.DB_VERSION);

    }

    /**Creating table in onCreate build-in function of SQLiteOpenHelper class.*/
    @Override
    public void onCreate(SQLiteDatabase db) {

        /** Writing basic Query in SQl to Create a table */
        String create  = "CREATE TABLE " + Param.TABLE_NAME + "(" + Param.KEY_ID+ " INTEGER PRIMARY KEY, "
                + Param.KEY_NAME + " TEXT, "+ Param.KEY_PHONE + " TEXT" + ")";

        /** Running the query*/
        db.execSQL(create);
        //Log Message to keep track of things
        Log.d("Owais","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


    /**function to add-data to the database*/
    public void addcontact(Contact contact)
    {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(Param.KEY_NAME,contact.getName());
        values.put(Param.KEY_PHONE,contact.getPhone());

        db.insert(Param.TABLE_NAME,null,values);
        db.close();

        //Log Message to keep track of things
        Log.d("Owais","Values inserted");
    }


    /**function to retrieve all the saved data in the database*/
    public List<Contact> allcontacts (){
        List <Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + Param.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);


        if(cursor.moveToFirst())
        {
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;

    }


    /** function to update the data in the database*/
    public int updatecontact(Contact contact)
    {
       SQLiteDatabase db = this.getWritableDatabase();

       ContentValues values = new ContentValues();
       values.put(Param.KEY_NAME, contact.getName());
       values.put(Param.KEY_PHONE, contact.getPhone());

       return db.update(Param.TABLE_NAME, values, Param.KEY_ID + "=?",
               new String[]{String.valueOf(contact.getId())});

    }


    /** function to delete a specific entry in the data base*/
    public void deletecontact(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Param.TABLE_NAME, Param.KEY_ID + "=?",
                new String[]{String.valueOf(id)});
        db.close();

        //Log Message to keep track of things
        Log.d("Owais","Deletion Complete");
    }


}