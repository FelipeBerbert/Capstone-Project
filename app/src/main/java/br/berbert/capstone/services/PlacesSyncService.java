package br.berbert.capstone.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import br.berbert.capstone.conn.PlacesSyncAdapter;

public class PlacesSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static PlacesSyncAdapter sPlacesSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("PlacesSyncService", "onCreate");
        synchronized (sSyncAdapterLock) {
            if (sPlacesSyncAdapter == null) {
                sPlacesSyncAdapter = new PlacesSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sPlacesSyncAdapter.getSyncAdapterBinder();
    }
}