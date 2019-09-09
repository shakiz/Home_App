package com.shakil.homeapp.activities.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.utils.Constants;

public class MeterDbHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "meter";

    private static final String COLUMN_METER_ID = "meter_id";
    private static final String COLUMN_METER_NAME = "meter_name";
    private static final String COLUMN_METER_ROOM = "meter_room";
    private static final String COLUMN_METER_TYPE = "meter_type";

    public MeterDbHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
