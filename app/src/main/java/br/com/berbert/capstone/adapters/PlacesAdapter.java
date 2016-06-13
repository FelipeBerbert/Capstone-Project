package br.com.berbert.capstone.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.berbert.capstone.R;
import br.com.berbert.capstone.models.Place;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 09/06/2016.
 *
 */
public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {


    private final int TYPE_HEADER = 0;
    private final int TYPE_NORMAL = 1;

    Context context;
    ArrayList<Place> placesList;
    private final OnItemClickListener listener;

    public PlacesAdapter(Context context, ArrayList<Place> placesList, OnItemClickListener listener) {
        this.placesList = placesList;
        this.context = context;
        this.listener = listener;
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
        return position == 0 ? TYPE_HEADER : TYPE_NORMAL;
    }

    @Override
    public void onBindViewHolder(PlacesViewHolder holder, int position) {
        holder.bind(placesList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }


    public static class PlacesViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView distance;
        public ImageView picture;

        public PlacesViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_place_name);
            distance = (TextView) itemView.findViewById(R.id.tv_place_distance);
            picture = (ImageView) itemView.findViewById(R.id.iv_place_picture);
        }

        public void bind(final Place place, final OnItemClickListener listener) { //TODO add onClickListener here
            name.setText(place.getName());
            distance.setText(distance.getContext().getString(R.string.lb_meter, place.getDistance()));
            picture.setImageDrawable(picture.getContext().getResources().getDrawable(place.getPicture()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(place);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Place item);
    }

}
