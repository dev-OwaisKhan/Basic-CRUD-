package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.contacts.MainActivity;
import com.example.contacts.R;

import java.util.ArrayList;
import java.util.List;

import modle.Contact;
import parameters.Param;

public class DataHandler extends SQLiteOpenHelper {

    public DataHandler(Context context)
    {
        super(context, Param.DB_NAME, null, Param.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create  = "CREATE TABLE " + Param.TABLE_NAME + "(" + Param.KEY_ID+ " INTEGER PRIMARY KEY, "
                + Param.KEY_NAME + " TEXT, "+ Param.KEY_PHONE + " TEXT" + ")";
        db.execSQL(create);
        Log.d("Owais","run");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addcontact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Param.KEY_NAME,contact.getName());
        values.put(Param.KEY_PHONE,contact.getPhone());

        db.insert(Param.TABLE_NAME,null,values);
        db.close();
    }

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

}