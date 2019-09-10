package com.shakil.homeapp.activities.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.model.MeterModel;
import com.shakil.homeapp.activities.utils.Constants;

public class MeterDbHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "meter";

    private static String TAG = "MeterDbHelper";

    private static final String COLUMN_METER_ID = "meter_id";
    private static final String COLUMN_METER_NAME = "meter_name";
    private static final String COLUMN_METER_ROOM = "meter_room";
    private static final String COLUMN_METER_TYPE = "meter_type";

    private String CREATE_METER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_METER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_METER_NAME + " TEXT,"+ COLUMN_METER_ROOM + " TEXT,"
            + COLUMN_METER_TYPE + " TEXT" + ")";

    private String DROP_METER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

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
        db.insert(TABLE_NAME, null, values);
        Log.v("----------------","");
        Log.v(TAG,"");
        Log.v("Meter Name : ",meterModel.getMeterName());
        Log.v("Associate Room : ",meterModel.getAssociateRoom());
        Log.v("Meter Type : ",meterModel.getMeterType());
        Log.v("----------------","");
        db.close();
    }
}
