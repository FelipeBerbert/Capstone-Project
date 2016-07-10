package br.berbert.capstone.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.berbert.capstone.R;
import br.berbert.capstone.models.Review;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 06/07/2016.
 *
 */
public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {

    List<Review> mReviewList;

    public ReviewsAdapter(List<Review> mReviewList) {
        this.mReviewList = mReviewList;
    }

    @Override
    public ReviewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewsViewHolder holder, int position) {
        holder.bind(mReviewList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mReviewList != null)
            return mReviewList.size();
        return 0;
    }

    public static class ReviewsViewHolder extends RecyclerView.ViewHolder {

        TextView author, text, rating;

        public ReviewsViewHolder(View itemView) {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.tv_author);
            text = (TextView) itemView.findViewById(R.id.tv_review_text);
            rating = (TextView) itemView.findViewById(R.id.tv_review_rating);
        }

        public void bind(Review item){
            author.setText(item.getAuthor_name());
            text.setText(item.getText());
            rating.setText(rating.getContext().getString(R.string.lb_review_rating, item.getRating()));
        }
    }
}