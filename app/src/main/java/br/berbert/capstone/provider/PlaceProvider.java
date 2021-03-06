/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.util.Arrays;

import br.berbert.capstone.BuildConfig;
import br.berbert.capstone.provider.base.BaseContentProvider;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.review.ReviewColumns;

public class PlaceProvider extends BaseContentProvider {
    private static final String TAG = PlaceProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "br.berbert.capstone";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_PHOTO = 0;
    private static final int URI_TYPE_PHOTO_ID = 1;

    private static final int URI_TYPE_PLACE = 2;
    private static final int URI_TYPE_PLACE_ID = 3;

    private static final int URI_TYPE_REVIEW = 4;
    private static final int URI_TYPE_REVIEW_ID = 5;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, PhotoColumns.TABLE_NAME, URI_TYPE_PHOTO);
        URI_MATCHER.addURI(AUTHORITY, PhotoColumns.TABLE_NAME + "/#", URI_TYPE_PHOTO_ID);
        URI_MATCHER.addURI(AUTHORITY, PlaceColumns.TABLE_NAME, URI_TYPE_PLACE);
        URI_MATCHER.addURI(AUTHORITY, PlaceColumns.TABLE_NAME + "/#", URI_TYPE_PLACE_ID);
        URI_MATCHER.addURI(AUTHORITY, ReviewColumns.TABLE_NAME, URI_TYPE_REVIEW);
        URI_MATCHER.addURI(AUTHORITY, ReviewColumns.TABLE_NAME + "/#", URI_TYPE_REVIEW_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return PlaceSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_PHOTO:
                return TYPE_CURSOR_DIR + PhotoColumns.TABLE_NAME;
            case URI_TYPE_PHOTO_ID:
                return TYPE_CURSOR_ITEM + PhotoColumns.TABLE_NAME;

            case URI_TYPE_PLACE:
                return TYPE_CURSOR_DIR + PlaceColumns.TABLE_NAME;
            case URI_TYPE_PLACE_ID:
                return TYPE_CURSOR_ITEM + PlaceColumns.TABLE_NAME;

            case URI_TYPE_REVIEW:
                return TYPE_CURSOR_DIR + ReviewColumns.TABLE_NAME;
            case URI_TYPE_REVIEW_ID:
                return TYPE_CURSOR_ITEM + ReviewColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_PHOTO:
            case URI_TYPE_PHOTO_ID:
                res.table = PhotoColumns.TABLE_NAME;
                res.idColumn = PhotoColumns._ID;
                res.tablesWithJoins = PhotoColumns.TABLE_NAME;
                if (PlaceColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + PlaceColumns.TABLE_NAME + " AS " + PhotoColumns.PREFIX_PLACE + " ON " + PhotoColumns.TABLE_NAME + "." + PhotoColumns.PLACE_ID + "=" + PhotoColumns.PREFIX_PLACE + "." + PlaceColumns._ID;
                }
                res.orderBy = PhotoColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_PLACE:
            case URI_TYPE_PLACE_ID:
                res.table = PlaceColumns.TABLE_NAME;
                res.idColumn = PlaceColumns._ID;
                res.tablesWithJoins = PlaceColumns.TABLE_NAME;
                res.orderBy = PlaceColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_REVIEW:
            case URI_TYPE_REVIEW_ID:
                res.table = ReviewColumns.TABLE_NAME;
                res.idColumn = ReviewColumns._ID;
                res.tablesWithJoins = ReviewColumns.TABLE_NAME;
                if (PlaceColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + PlaceColumns.TABLE_NAME + " AS " + ReviewColumns.PREFIX_PLACE + " ON " + ReviewColumns.TABLE_NAME + "." + ReviewColumns.PLACE_ID + "=" + ReviewColumns.PREFIX_PLACE + "." + PlaceColumns._ID;
                }
                res.orderBy = ReviewColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_PHOTO_ID:
            case URI_TYPE_PLACE_ID:
            case URI_TYPE_REVIEW_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
