package br.berbert.capstone.adapters;

import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.berbert.capstone.R;
import br.berbert.capstone.Utilities;
import br.berbert.capstone.models.Photo;
import br.berbert.capstone.models.Place;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.photo.PhotoCursor;
import br.berbert.capstone.provider.photo.PhotoSelection;
import br.berbert.capstone.provider.place.PlaceCursor;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 09/06/2016.
 *
 */
public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {


    private final int TYPE_HEADER = 0;
    private final int TYPE_NORMAL = 1;

    private PlaceCursor mCursor;
    Context mContext;
    //ArrayList<Place> mPlacesList;
    Location mUserLocation;
    private final OnItemClickListener mListener;

    public PlacesAdapter(Context context, OnItemClickListener listener) {
        //mPlacesList = placesList;
        mContext = context;
        mListener = listener;
    }

    @Override
    public PlacesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_NORMAL)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_card, parent, false);
        else
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_card_first, parent, false);
        return new PlacesViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 && mContext.getResources().getInteger(R.integer.grid_header_column_spam) > 1 ? TYPE_HEADER : TYPE_NORMAL;
    }

    @Override
    public void onBindViewHolder(PlacesViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        holder.bind(position, mListener);
    }

    @Override
    public int getItemCount() {
        if (mCursor != null)
            return mCursor.getCount();
        return 0;
    }


    public class PlacesViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView distance;
        public ImageView picture;
        public ImageView distanceBack;

        public PlacesViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_place_name);
            distance = (TextView) itemView.findViewById(R.id.tv_place_distance);
            picture = (ImageView) itemView.findViewById(R.id.iv_place_picture);
            distanceBack = (ImageView) itemView.findViewById(R.id.iv_distance_background);
        }

        public void bind(final int position, final OnItemClickListener listener) {
            Location userLocation = Utilities.loadUserLocation(mContext);
            mCursor.moveToPosition(position);
            final Place place = mCursor.getPlace(mContext, false);
            name.setText(place.getName());
            distance.setText(distance.getContext().getString(R.string.lb_meter, (long) place.getDistance(userLocation)));
            String mainPhotoReference = mCursor.getMainPhotoReference(mContext);
            if (mainPhotoReference != null){
                Photo photo = new Photo();
                photo.setPhoto_reference(mainPhotoReference);
                photo.fetchPhoto(picture);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(place, PlacesViewHolder.this);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Place item, PlacesViewHolder vh);
    }

    public void swapCursor(PlaceCursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
    }

    public Cursor getCursor() {
        return mCursor;
    }
}
