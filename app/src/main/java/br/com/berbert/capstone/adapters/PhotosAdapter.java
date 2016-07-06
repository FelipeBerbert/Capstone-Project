package br.com.berbert.capstone.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import br.com.berbert.capstone.R;
import br.com.berbert.capstone.models.Photo;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 05/07/2016.
 *
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    List<Photo> photosList;

    public PhotosAdapter(List<Photo> photosList) {
        this.photosList = photosList;
    }

    @Override
    public PhotosAdapter.PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotosAdapter.PhotosViewHolder holder, int position) {
        holder.bind(photosList.get(position));
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

        public void bind(final Photo photo){
            photo.fetchPhoto(ivPhoto);
            ivPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    photo.loadPhoto(ivPhoto.getContext());
                }
            });
        }
    }
}
