package com.shakil.homeapp.activities.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.utils.Constants;

public class RoomDbHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "room";

    private static final String COLUMN_ROOM_ID = "room_id";
    private static final String COLUMN_ROOM_NAME = "room_name";
    private static final String COLUMN_RENT_MONTH = "rent_month";
    private static final String COLUMN_ROOM_METER = "room_meter";
    private static final String COLUMN_TENANT_NAME = "tenant_name";
    private static final String COLUMN_ADVANCED_AMOUNT = "advanced_amount";

    public RoomDbHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
