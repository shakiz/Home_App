package com.shakil.homeapp.activities.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.model.MeterModel;
import com.shakil.homeapp.activities.utils.Constants;
import java.util.ArrayList;

public class MeterDbHelper extends SQLiteOpenHelper {


    private static String TAG = "MeterDbHelper";

    private static final String COLUMN_METER_ID = "meter_id";
    private static final String COLUMN_METER_NAME = "meter_name";
    private static final String COLUMN_METER_ROOM = "meter_room";
    private static final String COLUMN_METER_TYPE = "meter_type";

    private String CREATE_METER_TABLE = "CREATE TABLE " + Constants.TABLE_NAME_METER + "("
            + COLUMN_METER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_METER_NAME + " TEXT,"+ COLUMN_METER_ROOM + " TEXT,"
            + COLUMN_METER_TYPE + " TEXT" + ")";

    private String DROP_METER_TABLE = "DROP TABLE IF EXISTS " + Constants.TABLE_NAME_METER;

    public MeterDbHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_METER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_METER_TABLE);
    }

    public void addMeter(MeterModel meterModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_METER_NAME, meterModel.getMeterName());
        values.put(COLUMN_METER_ROOM, meterModel.getAssociateRoom());
        values.put(COLUMN_METER_TYPE, meterModel.getMeterType());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_METER, null, values);
        Log.v("----------------","");
        Log.v(TAG,"");
        Log.v("Meter Name : ",meterModel.getMeterName());
        Log.v("Associate Room : ",meterModel.getAssociateRoom());
        Log.v("Meter Type : ",meterModel.getMeterType());
        Log.v("----------------","");
        db.close();
    }

    public ArrayList<MeterModel> getAllMeterDetails() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_METER_NAME,
                COLUMN_METER_ROOM,
                COLUMN_METER_TYPE
        };
        // sorting orders
        String sortOrder =
                COLUMN_METER_NAME + " ASC";
        ArrayList<MeterModel> meterModelList = new ArrayList<MeterModel>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_METER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MeterModel meterModel = new MeterModel();
                meterModel.setMeterName(cursor.getString(cursor.getColumnIndex(COLUMN_METER_NAME)));
                meterModel.setAssociateRoom(cursor.getString(cursor.getColumnIndex(COLUMN_METER_ROOM)));
                meterModel.setMeterType(cursor.getString(cursor.getColumnIndex(COLUMN_METER_TYPE)));
                // Adding food item record to list
                meterModelList.add(meterModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return meterModelList;
    }
}
