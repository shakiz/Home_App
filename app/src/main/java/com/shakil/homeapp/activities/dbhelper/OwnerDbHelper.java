package com.shakil.homeapp.activities.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.utils.Constants;

public class OwnerDbHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "owner";

    private static final String COLUMN_ROW_ID = "row_id";
    private static final String COLUMN_TOTAL_ROOMS = "total_rooms";
    private static final String COLUMN_TOTAL_METERS = "total_meter";
    private static final String COLUMN_TOTAL_EARNINGS = "total_earnings";

    public OwnerDbHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
