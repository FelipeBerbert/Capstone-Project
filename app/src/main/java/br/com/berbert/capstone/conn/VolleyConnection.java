package br.com.berbert.capstone.conn;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Code Snippet from: https://developer.android.com/training/volley/requestqueue.html
 */
public class VolleyConnection {
    private static VolleyConnection mVolleyConnection;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private VolleyConnection(Context context){
        mContext = context;
        getRequestQueue();
    }

    public static synchronized VolleyConnection getInstance(Context context) {
        if (mVolleyConnection == null)
            mVolleyConnection = new VolleyConnection(context);

        return mVolleyConnection;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null)
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
