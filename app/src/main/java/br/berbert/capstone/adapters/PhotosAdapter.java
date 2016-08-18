package br.berbert.capstone.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;

import br.berbert.capstone.CapstoneApplication;
import br.berbert.capstone.R;
import br.berbert.capstone.models.Photo;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 05/07/2016.
 *
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    List<Photo> photosList;
    CapstoneApplication mApp;

    public PhotosAdapter(CapstoneApplication app, List<Photo> photosList) {
        mApp = app;
        this.photosList = photosList;
    }

    @Override
    public PhotosAdapter.PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotosAdapter.PhotosViewHolder holder, int position) {
        holder.bind(photosList.get(position), mApp);
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    public static class PhotosViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;

        public PhotosViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView;
        }

        public void bind(final Photo photo, final CapstoneApplication app){
            photo.fetchPhoto(ivPhoto);
            ivPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Tracker tracker = app.getDefaultTracker();
                    tracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Click")
                            .setAction("Photo")
                            .setLabel(photo.getPhoto_reference())
                            .build());
                    photo.loadPhoto(ivPhoto.getContext());

                }
            });
        }
    }
}
