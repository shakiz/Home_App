package com.shakil.homeapp.activities.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.model.MeterModel;
import com.shakil.homeapp.activities.model.RentModel;
import com.shakil.homeapp.activities.model.RoomModel;
import com.shakil.homeapp.activities.model.TenantModel;
import com.shakil.homeapp.activities.utils.Constants;
import java.util.ArrayList;

public class DbHelperParent extends SQLiteOpenHelper {

    private String CREATE_TABLE_QUERY;
    private String DROP_TABLE_QUERY;
    private static String TAG = "DbHelperParent";


    //Meter table columns
    private static final String COLUMN_METER_ID = "meter_id";
    private static final String COLUMN_METER_NAME = "meter_name";
    private static final String COLUMN_METER_ROOM = "meter_room";
    private static final String COLUMN_METER_TYPE = "meter_type";

    //Room table columns
    private static final String COLUMN_ROOM_ID = "room_id";
    private static final String COLUMN_ROOM_NAME = "room_name";
    private static final String COLUMN_RENT_MONTH = "rent_month";
    private static final String COLUMN_ROOM_METER = "room_meter";
    private static final String COLUMN_TENANT_NAME = "tenant_name";
    private static final String COLUMN_ADVANCED_AMOUNT = "advanced_amount";

    //Tenant table columns
    private static final String COLUMN_TENANT_ID = "tenant_id";
    private static final String COLUMN_NEW_TENANT_NAME = "tenant_name";
    private static final String COLUMN_STARTING_MONTH = "starting_month";
    private static final String COLUMN_TENANT_ASSOCIATE_METER = "associate_meter";


    //Rent table columns
    private static final String COLUMN_RENT_ID = "rent_id";
    private static final String COLUMN_RENT_MONTH_NAME = "rent_month_name";
    private static final String COLUMN_RENT_ROOM = "rent_room";
    private static final String COLUMN_RENT_AMOUNT = "rent_amount";

    //Meter table starts
    private String CREATE_METER_TABLE = "CREATE TABLE " + Constants.TABLE_NAME_METER + "("
            + COLUMN_METER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_METER_NAME + " TEXT,"+ COLUMN_METER_ROOM + " TEXT,"
            + COLUMN_METER_TYPE + " TEXT" + ")";

    private String DROP_METER_TABLE = "DROP TABLE IF EXISTS " + Constants.TABLE_NAME_METER;
    //Meter table Ends

    //Room table starts
    private String CREATE_ROOM_TABLE = "CREATE TABLE " + Constants.TABLE_NAME_ROOM + "("
            + COLUMN_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ROOM_NAME + " TEXT,"+ COLUMN_RENT_MONTH + " TEXT,"
            + COLUMN_ROOM_METER + " TEXT," + COLUMN_TENANT_NAME + " TEXT," + COLUMN_ADVANCED_AMOUNT + " REAL" + ")";

    private String DROP_ROOM_TABLE = "DROP TABLE IF EXISTS " + Constants.TABLE_NAME_ROOM;
    //Room table ends

    //Tenant table starts
    private String CREATE_TENANT_TABLE = "CREATE TABLE " + Constants.TABLE_NAME_TENANT + "("
            + COLUMN_TENANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NEW_TENANT_NAME + " TEXT,"+ COLUMN_STARTING_MONTH + " TEXT,"
            + COLUMN_TENANT_ASSOCIATE_METER + " TEXT" + ")";

    private String DROP_TENANT_TABLE = "DROP TABLE IF EXISTS " + Constants.TABLE_NAME_TENANT;
    //Meter table Ends

    //Tenant table starts
    private String CREATE_RENT_TABLE = "CREATE TABLE " + Constants.TABLE_NAME_RENT + "("
            + COLUMN_RENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_RENT_MONTH_NAME + " TEXT,"+ COLUMN_RENT_ROOM + " TEXT,"
            + COLUMN_RENT_AMOUNT + " REAL" + ")";

    private String DROP_RENT_TABLE = "DROP TABLE IF EXISTS " + Constants.TABLE_NAME_RENT;
    //Meter table Ends

    public DbHelperParent(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_METER_TABLE);
        sqLiteDatabase.execSQL(CREATE_ROOM_TABLE);
        sqLiteDatabase.execSQL(CREATE_TENANT_TABLE);
        sqLiteDatabase.execSQL(CREATE_RENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_METER_TABLE);
        sqLiteDatabase.execSQL(DROP_ROOM_TABLE);
        sqLiteDatabase.execSQL(DROP_TENANT_TABLE);
        sqLiteDatabase.execSQL(DROP_RENT_TABLE);
    }


    //Meter starts
    public void addMeter(MeterModel meterModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_METER_NAME, meterModel.getMeterName());
        values.put(COLUMN_METER_ROOM, meterModel.getAssociateRoom());
        values.put(COLUMN_METER_TYPE, meterModel.getMeterType());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_METER, null, values);
        Log.v("----------------","Meter Data");
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

    public ArrayList<String> getMeterNames() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_METER_NAME,
        };
        // sorting orders
        String sortOrder =
                COLUMN_METER_NAME + " ASC";
        ArrayList<String> meterNameList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_METER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        meterNameList.add("Select Meter Name");
        if (cursor.moveToFirst()) {
            do {
                // Adding food item record to list
                meterNameList.add(cursor.getString(cursor.getColumnIndex(COLUMN_METER_NAME)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return meterNameList;
    }
    //Meter ends

    //Room starts
    public void addRoom(RoomModel roomModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_NAME, roomModel.getRoomName());
        values.put(COLUMN_RENT_MONTH, roomModel.getStartMonth());
        values.put(COLUMN_ROOM_METER, roomModel.getAssociateMeter());
        values.put(COLUMN_TENANT_NAME, roomModel.getTenantName());
        values.put(COLUMN_ADVANCED_AMOUNT, roomModel.getAdvancedAmount());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_ROOM, null, values);
        Log.v("----------------","");
        Log.v(TAG,"Room Data");
        Log.v("Room Name : ",roomModel.getRoomName());
        Log.v("Start Date : ",roomModel.getStartMonth());
        Log.v("Associate Meter : ",roomModel.getAssociateMeter());
        Log.v("Tenant Name : ",""+roomModel.getTenantName());
        Log.v("Advanced Amount : ",""+roomModel.getAdvancedAmount());
        Log.v("----------------","");
        db.close();
    }

    //returns number of total rooms
    public int getTotalRoomRows(){
        String query = "select * from "+Constants.TABLE_NAME_ROOM;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query ,null);
        int count = cursor.getCount();
        return count;
    }

    public ArrayList<RoomModel> getAllRoomDetails() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ROOM_NAME,
                COLUMN_RENT_MONTH,
                COLUMN_ROOM_METER,
                COLUMN_TENANT_NAME,
                COLUMN_ADVANCED_AMOUNT
        };
        // sorting orders
        String sortOrder =
                COLUMN_ROOM_NAME + " ASC";
        ArrayList<RoomModel> roomModelList = new ArrayList<RoomModel>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_ROOM, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomModel roomModel = new RoomModel();
                roomModel.setRoomName(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_NAME)));
                roomModel.setStartMonth(cursor.getString(cursor.getColumnIndex(COLUMN_RENT_MONTH)));
                roomModel.setAssociateMeter(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_METER)));
                roomModel.setTenantName(cursor.getString(cursor.getColumnIndex(COLUMN_TENANT_NAME)));
                roomModel.setAdvancedAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_ADVANCED_AMOUNT)));
                // Adding food item record to list
                roomModelList.add(roomModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return roomModelList;
    }

    public ArrayList<String> getRoomNames() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ROOM_NAME,
        };
        // sorting orders
        String sortOrder =
                COLUMN_ROOM_NAME + " ASC";
        ArrayList<String> roomNameList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_ROOM, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        roomNameList.add("Select Room Name");
        if (cursor.moveToFirst()) {
            do {
                // Adding food item record to list
                roomNameList.add(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_NAME)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return roomNameList;
    }
    //Room ends

    //Tenant starts
    public void addTenant(TenantModel tenantModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NEW_TENANT_NAME, tenantModel.getTenantName());
        values.put(COLUMN_STARTING_MONTH, tenantModel.getStartingMonth());
        values.put(COLUMN_TENANT_ASSOCIATE_METER, tenantModel.getAssociateMeter());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_TENANT, null, values);
        Log.v("----------------","");
        Log.v(TAG,"Tenant Data");
        Log.v("Tenant Name : ",tenantModel.getTenantName());
        Log.v("Start Date : ",tenantModel.getStartingMonth());
        Log.v("Associate Meter : ",tenantModel.getAssociateMeter());
        Log.v("----------------","");
        db.close();
    }

    public ArrayList<TenantModel> getAllTenantDetails() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_NEW_TENANT_NAME,
                COLUMN_STARTING_MONTH,
                COLUMN_TENANT_ASSOCIATE_METER
        };
        // sorting orders
        String sortOrder =
                COLUMN_NEW_TENANT_NAME + " ASC";
        ArrayList<TenantModel> tenantModels = new ArrayList<TenantModel>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_TENANT, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TenantModel tenantModel = new TenantModel();
                tenantModel.setTenantName(cursor.getString(cursor.getColumnIndex(COLUMN_NEW_TENANT_NAME)));
                tenantModel.setStartingMonth(cursor.getString(cursor.getColumnIndex(COLUMN_STARTING_MONTH)));
                tenantModel.setAssociateMeter(cursor.getString(cursor.getColumnIndex(COLUMN_TENANT_ASSOCIATE_METER)));
                // Adding food item record to list
                tenantModels.add(tenantModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return tenantModels;
    }

    public ArrayList<String> getTenantNames() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_NEW_TENANT_NAME,
        };
        // sorting orders
        String sortOrder =
                COLUMN_NEW_TENANT_NAME + " ASC";
        ArrayList<String> tenantNameList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_TENANT, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        tenantNameList.add("Select Tenant Name");
        if (cursor.moveToFirst()) {
            do {
                // Adding food item record to list
                tenantNameList.add(cursor.getString(cursor.getColumnIndex(COLUMN_NEW_TENANT_NAME)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return tenantNameList;
    }
    //Tenant ends


    //Rent starts
    public void addRent(RentModel rentModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_RENT_MONTH_NAME, rentModel.getRentForMonth());
        values.put(COLUMN_RENT_ROOM, rentModel.getRentRoom());
        values.put(COLUMN_RENT_AMOUNT, rentModel.getRentAmount());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_RENT, null, values);
        Log.v("----------------","");
        Log.v(TAG,"Rent Data");
        Log.v("Rent month Name : ",rentModel.getRentForMonth());
        Log.v("Rent room : ",rentModel.getRentRoom());
        Log.v("Amount : ",""+rentModel.getRentAmount());
        Log.v("----------------","");
        db.close();
    }

    public ArrayList<RentModel> getAllRentDetails() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_RENT_MONTH_NAME,
                COLUMN_RENT_ROOM,
                COLUMN_RENT_AMOUNT
        };
        // sorting orders
        String sortOrder =
                COLUMN_RENT_ROOM + " ASC";
        ArrayList<RentModel> rentModels = new ArrayList<RentModel>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_RENT, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RentModel rentModel = new RentModel();
                rentModel.setRentForMonth(cursor.getString(cursor.getColumnIndex(COLUMN_RENT_MONTH_NAME)));
                rentModel.setRentRoom(cursor.getString(cursor.getColumnIndex(COLUMN_RENT_ROOM)));
                rentModel.setRentAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_RENT_AMOUNT)));
                // Adding food item record to list
                rentModels.add(rentModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return rentModels;
    }
    //Rent ends
}
