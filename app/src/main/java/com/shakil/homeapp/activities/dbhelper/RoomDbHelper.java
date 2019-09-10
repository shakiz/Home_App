package com.shakil.homeapp.activities.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.model.RoomModel;
import com.shakil.homeapp.activities.utils.Constants;

public class RoomDbHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "room";

    private static String TAG = "RoomDbHelper";

    private static final String COLUMN_ROOM_ID = "room_id";
    private static final String COLUMN_ROOM_NAME = "room_name";
    private static final String COLUMN_RENT_MONTH = "rent_month";
    private static final String COLUMN_ROOM_METER = "room_meter";
    private static final String COLUMN_TENANT_NAME = "tenant_name";
    private static final String COLUMN_ADVANCED_AMOUNT = "advanced_amount";

    private String CREATE_ROOM_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ROOM_NAME + " TEXT,"+ COLUMN_RENT_MONTH + " TEXT,"
            + COLUMN_ROOM_METER + " TEXT," + COLUMN_TENANT_NAME + " TEXT," + COLUMN_ADVANCED_AMOUNT + " REAL" + ")";

    private String DROP_ROOM_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public RoomDbHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ROOM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_ROOM_TABLE);
    }

    public void addRoom(RoomModel roomModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_NAME, roomModel.getRoomName());
        values.put(COLUMN_RENT_MONTH, roomModel.getStartDate());
        values.put(COLUMN_ROOM_METER, roomModel.getAssociateMeter());
        values.put(COLUMN_TENANT_NAME, roomModel.getTenantName());
        values.put(COLUMN_ADVANCED_AMOUNT, roomModel.getAdvancedAmount());
        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        Log.v("----------------","");
        Log.v(TAG,"");
        Log.v("Room Name : ",roomModel.getRoomName());
        Log.v("Start Date : ",roomModel.getStartDate());
        Log.v("Associate Meter : ",roomModel.getAssociateMeter());
        Log.v("Tenant Name : ",""+roomModel.getTenantName());
        Log.v("Advanced Amount : ",""+roomModel.getAdvancedAmount());
        Log.v("----------------","");
        db.close();
    }
}
