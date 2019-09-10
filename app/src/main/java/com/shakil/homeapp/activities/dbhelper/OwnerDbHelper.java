package com.shakil.homeapp.activities.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.model.DashboardModel;
import com.shakil.homeapp.activities.utils.Constants;

public class OwnerDbHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "owner";

    private static String TAG = "OwnerDbHelper";

    private static final String COLUMN_ROW_ID = "row_id";
    private static final String COLUMN_TOTAL_ROOMS = "total_rooms";
    private static final String COLUMN_TOTAL_METERS = "total_meter";
    private static final String COLUMN_TOTAL_EARNINGS = "total_earnings";

    private String CREATE_OWNER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TOTAL_METERS + " REAL,"+ COLUMN_TOTAL_ROOMS + " REAL,"
            + COLUMN_TOTAL_EARNINGS + " REAL" + ")";

    private String DROP_OWNER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public OwnerDbHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_OWNER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_OWNER_TABLE);
    }

    public void addOwnerDashboard(DashboardModel dashboardModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TOTAL_ROOMS, dashboardModel.getTotal_room());
        values.put(COLUMN_TOTAL_METERS, dashboardModel.getTotal_meter());
        values.put(COLUMN_TOTAL_EARNINGS, dashboardModel.getTotal_earnings());
        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        Log.v("----------------","");
        Log.v(TAG,"");
        Log.v("Total Rooms : ",""+dashboardModel.getTotal_room());
        Log.v("Total Meter : ",""+dashboardModel.getTotal_meter());
        Log.v("Total Earnings : ",""+dashboardModel.getTotal_earnings());
        Log.v("----------------","");
        db.close();
    }
}
