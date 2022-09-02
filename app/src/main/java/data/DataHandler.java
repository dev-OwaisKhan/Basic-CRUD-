package data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import parameters.Param;

public class DataHandler extends SQLiteOpenHelper {

    public DataHandler(Context context)
    {
        super(context, Param.DB_NAME, null, Param.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create  = "CREATE TABLE "+Param.TABLE_NAME+" (" + Param.KEY_ID+ "INTEGER PRIMARY KEY, B6"
                + Param.KEY_NAME + "TEXT, "+ Param.KEY_PHONE + "TEXT )";
        sqLiteDatabase.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}