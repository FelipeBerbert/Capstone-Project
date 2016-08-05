package br.berbert.capstone.widget;

import android.content.Intent;
import android.database.Cursor;
import android.os.Binder;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import br.berbert.capstone.provider.place.PlaceColumns;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 05/08/2016.
 */
public class WidgetRemoteViewsService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteViewsFactory() {
            private Cursor dataCursor = null;

            @Override
            public void onCreate() {}

            @Override
            public void onDataSetChanged() {
                if (dataCursor != null)
                    dataCursor.close();

                final long identityToken = Binder.clearCallingIdentity();
                dataCursor = getContentResolver().query(
                        PlaceColumns.CONTENT_URI,
                        PlaceColumns.ALL_COLUMNS,
                        null,
                        null,
                        null);
                Binder.restoreCallingIdentity(identityToken);
            }

            @Override
            public void onDestroy() {
                if (dataCursor != null) {
                    dataCursor.close();
                    dataCursor = null;
                }
            }

            @Override
            public int getCount() {
                if (dataCursor !=null)
                    return dataCursor.getCount();
                else
                    return 0;
            }

            @Override
            public RemoteViews getViewAt(int i) {
                return null;
            }

            @Override
            public RemoteViews getLoadingView() {
                return null;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
        };
    }
}
