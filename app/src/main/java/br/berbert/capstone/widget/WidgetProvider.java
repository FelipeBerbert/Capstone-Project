package br.berbert.capstone.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.TaskStackBuilder;
import android.widget.RemoteViews;

import br.berbert.capstone.DetailActivity;
import br.berbert.capstone.MainActivity;
import br.berbert.capstone.R;
import br.berbert.capstone.conn.PlacesSyncAdapter;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 04/08/2016.
 * Provider for the app widget.
 */
public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            // Create an Intent to launch MainActivity
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            views.setOnClickPendingIntent(R.id.fl_header, pendingIntent);

            views.setRemoteAdapter(R.id.rv_widget_list, new Intent(context, WidgetRemoteViewsService.class));

            Intent clickIntent;
            if (context.getResources().getBoolean(R.bool.is_tablet_layout))
                clickIntent = new Intent(context, MainActivity.class);
            else
                clickIntent = new Intent(context, DetailActivity.class);

            PendingIntent clickPendingIntentTemplate = TaskStackBuilder.create(context)
                    .addNextIntentWithParentStack(clickIntent).getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            views.setPendingIntentTemplate(R.id.rv_widget_list, clickPendingIntentTemplate);
            views.setEmptyView(R.id.rv_widget_list, R.id.tv_widget_empty);

            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals(PlacesSyncAdapter.PLACES_DATA_UPDATED)) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, getClass()));
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.rv_widget_list);
        }
    }
}
