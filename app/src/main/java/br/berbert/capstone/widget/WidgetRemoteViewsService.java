package br.berbert.capstone.widget;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.concurrent.ExecutionException;

import br.berbert.capstone.DetailActivity;
import br.berbert.capstone.R;
import br.berbert.capstone.models.Photo;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.place.PlaceCursor;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 05/08/2016.
 */
public class WidgetRemoteViewsService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteViewsFactory() {
//            private Cursor dataCursor = null;
            private PlaceCursor placeCursor = null;

            @Override
            public void onCreate() {}

            @Override
            public void onDataSetChanged() {
                if (placeCursor != null)
                    placeCursor.close();

                final long identityToken = Binder.clearCallingIdentity();

                placeCursor = new PlaceCursor(getContentResolver().query(
                        PlaceColumns.CONTENT_URI,
                        PlaceColumns.ALL_COLUMNS,
                        null,
                        null,
                        null));
                Binder.restoreCallingIdentity(identityToken);
            }

            @Override
            public void onDestroy() {
                if (placeCursor != null) {
                    placeCursor.close();
                    placeCursor = null;
                }
            }

            @Override
            public int getCount() {
                if (placeCursor !=null)
                    return placeCursor.getCount();
                else
                    return 0;
            }

            @Override
            public RemoteViews getViewAt(int position) {
                if (position == AdapterView.INVALID_POSITION || placeCursor == null || !placeCursor.moveToPosition(position)) {
                    return null;
                }
                RemoteViews views = new RemoteViews(getPackageName(), R.layout.item_place_widget);

                String mainPhotoReference = placeCursor.getMainPhotoReference(WidgetRemoteViewsService.this);
                if (mainPhotoReference != null) {
                    Photo photo = new Photo();
                    photo.setPhoto_reference(mainPhotoReference);
                    String placePhotoUrl = photo.buildRequest(WidgetRemoteViewsService.this);
                    Bitmap placePicture = null;
                    try {
                        placePicture = Glide.with(WidgetRemoteViewsService.this)
                                .load(placePhotoUrl)
                                .asBitmap()
                                //.error(weatherArtResourceId)
                                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();
                    } catch (InterruptedException | ExecutionException e) {
                        Log.e("WidgetRemoteViewsServ", "Error downloading place photo: " + placePhotoUrl, e);
                    }
                    if (placePicture != null) {
                        views.setImageViewBitmap(R.id.iv_place_picture, placePicture);
                    }
                }

                views.setTextViewText(R.id.tv_place_distance, getString(R.string.lb_meter, placeCursor.getDistance()!=null?placeCursor.getDistance().longValue():0L));
                views.setTextViewText(R.id.tv_place_name, placeCursor.getName());

                final Intent intent = new Intent();
                intent.putExtra(DetailActivity.PARAM_PLACE, placeCursor.getExternalId());
                intent.putExtra(DetailActivity.PARAM_PLACE_NAME, placeCursor.getName());
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                views.setOnClickFillInIntent(R.id.tv_place_name, intent);
                final Intent navigateIntent = new Intent();
                navigateIntent.putExtra(DetailActivity.PARAM_PLACE, placeCursor.getExternalId());
                navigateIntent.putExtra(DetailActivity.PARAM_PLACE_NAME, placeCursor.getName());
                navigateIntent.putExtra(DetailActivity.PARAM_NAVIGATE, true);
                navigateIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                views.setOnClickFillInIntent(R.id.iv_distance_background, navigateIntent);
                return views;
            }

            @Override
            public RemoteViews getLoadingView() {
                return new RemoteViews(getPackageName(), R.layout.item_place_widget);
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int i) {
                if (placeCursor.moveToPosition(i))
                    return placeCursor.getId();
                return i;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
        };
    }
}
