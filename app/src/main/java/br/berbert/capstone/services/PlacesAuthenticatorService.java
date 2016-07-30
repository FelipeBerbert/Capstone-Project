package br.berbert.capstone.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import br.berbert.capstone.conn.PlacesAuthenticator;

/**
 * A bound Service that instantiates the authenticator
 * when started.
 * Code snippet from: https://developer.android.com/training/sync-adapters/creating-authenticator.html
 */
public class PlacesAuthenticatorService extends Service {
    // Instance field that stores the authenticator object
    private PlacesAuthenticator mAuthenticator;
    @Override
    public void onCreate() {
        // Create a new authenticator object
        mAuthenticator = new PlacesAuthenticator(this);
    }
    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}