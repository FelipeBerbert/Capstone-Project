/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import br.berbert.capstone.BuildConfig;
import br.berbert.capstone.provider.geometry.GeometryColumns;
import br.berbert.capstone.provider.location.LocationColumns;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.review.ReviewColumns;

public class PlaceSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = PlaceSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "capstone.db";
    private static final int DATABASE_VERSION = 1;
    private static PlaceSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final PlaceSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_GEOMETRY = "CREATE TABLE IF NOT EXISTS "
            + GeometryColumns.TABLE_NAME + " ( "
            + GeometryColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + GeometryColumns.LOCATION_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_location_id FOREIGN KEY (" + GeometryColumns.LOCATION_ID + ") REFERENCES location (_id) ON DELETE NO ACTION"
            + " );";

    public static final String SQL_CREATE_TABLE_LOCATION = "CREATE TABLE IF NOT EXISTS "
            + LocationColumns.TABLE_NAME + " ( "
            + LocationColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + LocationColumns.LAT + " REAL, "
            + LocationColumns.LNG + " REAL "
            + " );";

    public static final String SQL_CREATE_TABLE_PHOTO = "CREATE TABLE IF NOT EXISTS "
            + PhotoColumns.TABLE_NAME + " ( "
            + PhotoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PhotoColumns.WIDTH + " INTEGER, "
            + PhotoColumns.HEIGHT + " INTEGER, "
            + PhotoColumns.PHOTO_REFERENCE + " TEXT, "
            + PhotoColumns.PLACE_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_place_id FOREIGN KEY (" + PhotoColumns.PLACE_ID + ") REFERENCES place (_id) ON DELETE CASCADE"
            + " );";

    public static final String SQL_CREATE_TABLE_PLACE = "CREATE TABLE IF NOT EXISTS "
            + PlaceColumns.TABLE_NAME + " ( "
            + PlaceColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PlaceColumns.EXTERNAL_ID + " TEXT NOT NULL, "
            + PlaceColumns.NAME + " TEXT, "
            + PlaceColumns.VICINITY + " TEXT, "
            + PlaceColumns.PHONE_NUMBER + " TEXT, "
            + PlaceColumns.DISTANCE + " REAL, "
            + PlaceColumns.GEOMETRY_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_geometry_id FOREIGN KEY (" + PlaceColumns.GEOMETRY_ID + ") REFERENCES geometry (_id) ON DELETE NO ACTION"
            + ", CONSTRAINT unique_id UNIQUE (place_id) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_REVIEW = "CREATE TABLE IF NOT EXISTS "
            + ReviewColumns.TABLE_NAME + " ( "
            + ReviewColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ReviewColumns.AUTHOR_NAME + " TEXT, "
            + ReviewColumns.TEXT + " TEXT, "
            + ReviewColumns.RATING + " INTEGER, "
            + ReviewColumns.PLACE_ID + " INTEGER NOT NULL "
            + ", CONSTRAINT fk_place_id FOREIGN KEY (" + ReviewColumns.PLACE_ID + ") REFERENCES place (_id) ON DELETE CASCADE"
            + " );";

    // @formatter:on

    public static PlaceSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static PlaceSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static PlaceSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new PlaceSQLiteOpenHelper(context);
    }

    private PlaceSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new PlaceSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static PlaceSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new PlaceSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private PlaceSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new PlaceSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_GEOMETRY);
        db.execSQL(SQL_CREATE_TABLE_LOCATION);
        db.execSQL(SQL_CREATE_TABLE_PHOTO);
        db.execSQL(SQL_CREATE_TABLE_PLACE);
        db.execSQL(SQL_CREATE_TABLE_REVIEW);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
