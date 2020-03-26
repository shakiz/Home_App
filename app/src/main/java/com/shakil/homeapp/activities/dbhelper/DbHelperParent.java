package com.shakil.homeapp.activities.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.shakil.homeapp.activities.model.meter.Meter;
import com.shakil.homeapp.activities.model.room.Rent;
import com.shakil.homeapp.activities.model.room.Room;
import com.shakil.homeapp.activities.model.tenant.Tenant;
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
    public void addMeter(Meter meter) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_METER_NAME, meter.getMeterName());
        values.put(COLUMN_METER_ROOM, meter.getAssociateRoom());
        values.put(COLUMN_METER_TYPE, meter.getMeterType());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_METER, null, values);
        Log.v("----------------","Meter Data");
        Log.v(TAG,"");
        Log.v("Meter Name : ", meter.getMeterName());
        Log.v("Associate Room : ", meter.getAssociateRoom());
        Log.v("Meter Type : ", meter.getMeterType());
        Log.v("----------------","");
        db.close();
    }

    public ArrayList<Meter> getAllMeterDetails() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_METER_NAME,
                COLUMN_METER_ROOM,
                COLUMN_METER_TYPE
        };
        // sorting orders
        String sortOrder =
                COLUMN_METER_NAME + " ASC";
        ArrayList<Meter> meterList = new ArrayList<Meter>();
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
                Meter meter = new Meter();
                meter.setMeterName(cursor.getString(cursor.getColumnIndex(COLUMN_METER_NAME)));
                meter.setAssociateRoom(cursor.getString(cursor.getColumnIndex(COLUMN_METER_ROOM)));
                meter.setMeterType(cursor.getString(cursor.getColumnIndex(COLUMN_METER_TYPE)));
                // Adding food item record to list
                meterList.add(meter);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return meterList;
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
    public void addRoom(Room room) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_NAME, room.getRoomName());
        values.put(COLUMN_RENT_MONTH, room.getStartMonth());
        values.put(COLUMN_ROOM_METER, room.getAssociateMeter());
        values.put(COLUMN_TENANT_NAME, room.getTenantName());
        values.put(COLUMN_ADVANCED_AMOUNT, room.getAdvancedAmount());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_ROOM, null, values);
        Log.v("----------------","");
        Log.v(TAG,"Room Data");
        Log.v("Room Name : ", room.getRoomName());
        Log.v("Start Date : ", room.getStartMonth());
        Log.v("Associate Meter : ", room.getAssociateMeter());
        Log.v("Tenant Name : ",""+ room.getTenantName());
        Log.v("Advanced Amount : ",""+ room.getAdvancedAmount());
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

    public ArrayList<Room> getAllRoomDetails() {
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
        ArrayList<Room> roomList = new ArrayList<Room>();
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
                Room room = new Room();
                room.setRoomName(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_NAME)));
                room.setStartMonth(cursor.getString(cursor.getColumnIndex(COLUMN_RENT_MONTH)));
                room.setAssociateMeter(cursor.getString(cursor.getColumnIndex(COLUMN_ROOM_METER)));
                room.setTenantName(cursor.getString(cursor.getColumnIndex(COLUMN_TENANT_NAME)));
                room.setAdvancedAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_ADVANCED_AMOUNT)));
                // Adding food item record to list
                roomList.add(room);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return roomList;
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
    public void addTenant(Tenant tenant) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NEW_TENANT_NAME, tenant.getTenantName());
        values.put(COLUMN_STARTING_MONTH, tenant.getStartingMonth());
        values.put(COLUMN_TENANT_ASSOCIATE_METER, tenant.getAssociateMeter());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_TENANT, null, values);
        Log.v("----------------","");
        Log.v(TAG,"Tenant Data");
        Log.v("Tenant Name : ", tenant.getTenantName());
        Log.v("Start Date : ", tenant.getStartingMonth());
        Log.v("Associate Meter : ", tenant.getAssociateMeter());
        Log.v("----------------","");
        db.close();
    }

    public ArrayList<Tenant> getAllTenantDetails() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_NEW_TENANT_NAME,
                COLUMN_STARTING_MONTH,
                COLUMN_TENANT_ASSOCIATE_METER
        };
        // sorting orders
        String sortOrder =
                COLUMN_NEW_TENANT_NAME + " ASC";
        ArrayList<Tenant> tenants = new ArrayList<Tenant>();
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
                Tenant tenant = new Tenant();
                tenant.setTenantName(cursor.getString(cursor.getColumnIndex(COLUMN_NEW_TENANT_NAME)));
                tenant.setStartingMonth(cursor.getString(cursor.getColumnIndex(COLUMN_STARTING_MONTH)));
                tenant.setAssociateMeter(cursor.getString(cursor.getColumnIndex(COLUMN_TENANT_ASSOCIATE_METER)));
                // Adding food item record to list
                tenants.add(tenant);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return tenants;
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
    public void addRent(Rent rent) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_RENT_MONTH_NAME, rent.getRentForMonth());
        values.put(COLUMN_RENT_ROOM, rent.getRentRoom());
        values.put(COLUMN_RENT_AMOUNT, rent.getRentAmount());
        // Inserting Row
        db.insert(Constants.TABLE_NAME_RENT, null, values);
        Log.v("----------------","");
        Log.v(TAG,"Rent Data");
        Log.v("Rent month Name : ", rent.getRentForMonth());
        Log.v("Rent room : ", rent.getRentRoom());
        Log.v("Amount : ",""+ rent.getRentAmount());
        Log.v("----------------","");
        db.close();
    }

    public ArrayList<Rent> getAllRentDetails() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_RENT_MONTH_NAME,
                COLUMN_RENT_ROOM,
                COLUMN_RENT_AMOUNT
        };
        // sorting orders
        String sortOrder =
                COLUMN_RENT_ROOM + " ASC";
        ArrayList<Rent> rents = new ArrayList<Rent>();
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
                Rent rent = new Rent();
                rent.setRentForMonth(cursor.getString(cursor.getColumnIndex(COLUMN_RENT_MONTH_NAME)));
                rent.setRentRoom(cursor.getString(cursor.getColumnIndex(COLUMN_RENT_ROOM)));
                rent.setRentAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_RENT_AMOUNT)));
                // Adding food item record to list
                rents.add(rent);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return roomModelList list
        return rents;
    }
    //Rent ends
}
